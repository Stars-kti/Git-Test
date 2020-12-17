package com.citic.common.util.excel;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.*;

/**
 * Excel 2.0
 * 增加sheet多页添加
 */
public class MarketExcelUtils {

    private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

    static {
        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumFractionDigits(6);
    }

    /**
     * 通过反射获取对象中的属性
     * null -> ""
     *
     * @param obj 对象
     * @return LinkedHashMap
     */
    public static Map<String, Object> bingReflex(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Object> map = new LinkedHashMap<>();
        for (Field field : fields) {
            ReflectionUtils.makeAccessible(field);
            Object value = ReflectionUtils.getField(field, obj);
            map.put(field.getName(), value == null ? "" : value);
        }
        return map;
    }

    /**
     * 通过反射获取List集合对象中的属性
     *
     * @param obj List集合对象
     * @return List -> map
     */
    public static List<Map> bingReflex(List<Object> obj) {
        List<Map> maps = new ArrayList<>();
        obj.forEach(o -> {
            Map<String, Object> reflex = bingReflex(o);
            maps.add(reflex);
        });
        return maps;
    }

    /**
     * 通过反射获取对象中属性的值
     *
     * @param obj 对象
     * @return List
     */
    public static List bingReflexValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List list = new ArrayList<>();
        for (Field field : fields) {
            ReflectionUtils.makeAccessible(field);
            Object value = ReflectionUtils.getField(field, obj);
            list.add(value == null ? "" : value);
        }
        return list;
    }

    /**
     * 将一个LIST格式数据导出成EXCEL表格
     * 数据会根据对象中的属性顺序导出
     * NULL 数据会自动替换成 ""
     *
     * @param response
     * @param title    表名
     * @param column   EXCEL表格表头
     * @param list     数据内容集合
     * @throws IOException
     */
    public static void excelExport(HttpServletResponse response, String title, String[] column, List<?> list) {
        try {
            //查询数据
            XSSFWorkbook wb = new XSSFWorkbook();//创建工作簿 HSSFWorkbook:Excel的文档对象
            XSSFCellStyle style = wb.createCellStyle(); //设置单元格格式
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中对齐格式
            XSSFFont titleFont = wb.createFont();//设置字体样式
            titleFont.setFontName("微软雅黑");//字体型号
            titleFont.setFontHeightInPoints((short) 24);//字体大小
            style.setFont(titleFont);//载入字体样式
            XSSFSheet sheet = wb.createSheet("sheet01");//创建页
//        sheet.setColumnWidth(0,90);//设置列宽
            XSSFRow row = null; //创建行
            //sheet是页 这个的意思在文档Sheet的第一行
            row = sheet.createRow(0);//创建第一行单元格
            //设置单元格格式
            row.setHeight((short) (29 * 20));//设置行高
            row.setRowStyle(style);
            //第一行标签
            for (int i = 0; i < column.length; i++) {
                row.createCell(i).setCellValue(column[i]);
            }
            XSSFFont textFont = wb.createFont();
            textFont.setFontName("微软雅黑");
            textFont.setFontHeightInPoints((short) 16);
            style.setFont(textFont);
            row.setRowStyle(style);
            //获取数据
            //筛选需要导出得数据
            //遍历集合数据，产生数据行
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 1);
                List reflexValue = bingReflexValue(list.get(i));
                for (int x = 0; x < reflexValue.size(); x++) {
                    row.createCell(x).setCellValue(String.valueOf(reflexValue.get(x)));
                    if (i == 0) {
                        // 调整每一列宽度
                        sheet.autoSizeColumn((short) i);
                        // 解决自动设置列宽中文失效的问题
                        sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
                    }
                }
            }
            // response.setContentType 设置格式为UTF-8 不然可能会乱码
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            //output流得到流
            OutputStream os;
            os = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=" + title + ".xlsx");
            wb.write(os);
            os.flush();//刷新流
            os.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过excel表头和数据导出
     *
     * @param file
     * @return List<List<Map>>
     */
    public static List<List<Map>> excelData(MultipartFile file) {
        return excelKeyValues(file);
    }

    public static List excelData(MultipartFile file, Integer id) {
        return excelDataHeader(file, id, null, null);
    }


    public static List<List<Map>> excelKeyValues(MultipartFile file) {
        Sheet sheet;
        List<List<Map>> listV = new ArrayList();
            Workbook workBook = getWorkBook(file);
            for (int s = 0; s < workBook.getNumberOfSheets(); s++) {
                int x = 0;
                sheet = workBook.getSheetAt(s);
                Row sheetRow = sheet.getRow(x);
                if (sheetRow.getLastCellNum() == 1) {
                    sheetRow = sheet.getRow(1);
                    x = 1;
                }
                //创建接收集的集合
                List<Map> mapList = new ArrayList<>();
                //转成map对象
                for (; x < sheet.getLastRowNum(); x++) {
                    Map map = new HashMap();
                    Row row = sheet.getRow(x + 1);
                    if (row.getLastCellNum() == 1) {
                        continue;
                    }
                    for (int i = 0; i < sheetRow.getLastCellNum(); i++) {
                        map.put(excelDataType(sheetRow.getCell(i)).trim(), excelDataType(row.getCell(i)).trim());
                    }
                    mapList.add(map);
                    listV.add(mapList);
                }
            }
        return listV;
    }

    /**
     * 解析Excel数据并接收，根据表头扫描
     * 数据长度需和表头对应，否则会缺少数据
     * NULL 数据会自动替换成 ""
     * Key值存放表头 对应值Value
     * 不适用复杂表结构
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static <T> List<T> excelDataHeader(MultipartFile file, Integer id, String keyJson, Class<T> clazz) {
        Sheet sheet;
        List data = new ArrayList();
        List<List<Map>> listV = new ArrayList();
        Workbook workBook = getWorkBook(file);
            for (int s = 0; s < workBook.getNumberOfSheets(); s++) {
                int x = 0;
                sheet = workBook.getSheetAt(s);
                Row sheetRow = sheet.getRow(0);
                if (sheetRow.getLastCellNum() == 1) {
                    sheetRow = sheet.getRow(1);
                    x = 1;
                }
                //创建接收集的集合
                List<Map> mapList = new ArrayList<>();
                //转成map对象
                Map key = JSONObject.parseObject(keyJson, Map.class);
                if (id != null) {
                    for (; x < sheet.getLastRowNum(); x++) {
                        Map map = new HashMap();
                        Row row = sheet.getRow(x + 1);
                        if (row.getLastCellNum() == 1) {
                            continue;
                        }
                        for (int i = 0; i < sheetRow.getLastCellNum(); i++) {
                            map.put(key.get(excelDataType(sheetRow.getCell(i)).trim()), excelDataType(row.getCell(i)));
                        }
                        mapList.add(map);
                    }
                } else {
                    for (; x < sheet.getLastRowNum(); x++) {
                        Map map = new HashMap();
                        Row row = sheet.getRow(x + 1);
                        if (row.getLastCellNum() == 1) {
                            continue;
                        }
                        for (int i = 0; i < sheetRow.getLastCellNum(); i++) {
                            map.put(excelDataType(sheetRow.getCell(i)), excelDataType(row.getCell(i)));
                        }
                        mapList.add(map);
                    }
                }
                listV.add(mapList);
            }
            listV.forEach(list -> {
                list.forEach(map -> {
                    String jsonString = JSONObject.toJSONString(map);
                    T t = JSONObject.parseObject(jsonString, clazz);
                    data.add(t);
                });
            });
        return data;
    }

    /**
     * 解析Excel数据并接收，根据数据内容扫描
     * NULL 数据会自动替换成 ""
     * 数据内容按照顺序存放至list
     * 不适用复杂表结构
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static List<List<List>> excelDataNotHeader(MultipartFile file) {
        Sheet sheet;
        List list = null;
            Workbook workBook = getWorkBook(file);
            list = new ArrayList();
            for (int s = 0; s < workBook.getNumberOfSheets(); s++) {
                sheet = workBook.getSheetAt(s);
                Row sheetRow = sheet.getRow(0);
                //创建接收集的集合
                List mapList = new ArrayList<>();
                for (int x = 0; x < sheet.getLastRowNum(); x++) {
                    List listData = new ArrayList<>();
                    Row row = sheet.getRow(x + 1);
                    for (int i = 0; i < sheetRow.getLastCellNum(); i++) {
                        list.add(excelDataType(row.getCell(i)));
                    }
                    mapList.add(listData);
                }
                list.add(mapList);
            }
        return list;
    }

    /**
     * 筛选表中数据的格式
     */
    public static String excelDataType(Cell cell) {
        return getDataType(cell, numberFormat);
    }

    public static String getDataType(Cell cell, NumberFormat numberFormat) {
        if (cell == null){
            return "";
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            double cellValue = cell.getNumericCellValue();
            String format = numberFormat.format(cellValue);
            return format;
        }
        return cell.getStringCellValue();
    }

    /**
     * 获取workbook
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(MultipartFile file) {

        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件格式
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        //判断文件格式
//        if (!fileType.equals("xls") && !fileType.equals("xlsx")) {
//            throw new CommonException(ErrorCode.FILE_FORMAT_ERROR);
//        }
        //读取文件
        InputStream inputStream;
        XSSFWorkbook workbook = null;
        try{
            inputStream = file.getInputStream();
            //03及以下excel版本
//        if (fileType.equals("xls")) {
//            return new HSSFWorkbook(inputStream);
//        }
            //07及以上excel版本
            OPCPackage pkg = OPCPackage.open(inputStream);
            workbook = new XSSFWorkbook(pkg);
        }catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return workbook;
    }

}
