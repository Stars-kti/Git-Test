package com.citic.common.util.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
 * Excel
 */
public class ExcelUtils {

    private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

    static {
        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumFractionDigits(6);
    }

    /**
     * 通过反射获取对象中的属性
     * null -> ""
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
            //创建工作簿 HSSFWorkbook:Excel的文档对象
            XSSFWorkbook wb = new XSSFWorkbook();
            //设置单元格格式
            XSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中对齐格式
            XSSFFont titleFont = wb.createFont();
            titleFont.setFontName("微软雅黑");
            titleFont.setFontHeightInPoints((short) 24);
            style.setFont(titleFont);
            XSSFSheet sheet = wb.createSheet("sheet01");
//        sheet.setColumnWidth(0,90);
            XSSFRow row = null;
            //sheet是页 这个的意思在文档Sheet的第一行
            row = sheet.createRow(0);
            //设置单元格格式
            row.setHeight((short) (29 * 20));
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
        OutputStream os = null;

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
    public static List<Map> excelDataHeader(MultipartFile file)  {
        Sheet sheet = null;
        try {
            sheet = getWorkBook(file).getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Row sheetRow = sheet.getRow(0);
        //创建接收集的集合
        List<Map> mapList = new ArrayList<>();
        for (int x = 0; x < sheet.getLastRowNum(); x ++ ){
            Map map = new HashMap();
            Row row = sheet.getRow(x + 1);
            int rowNum = sheetRow.getRowNum();
            for (int i = 0; i < sheetRow.getLastCellNum(); i ++ ) {
                map.put(excelDataType(sheetRow.getCell(i)), excelDataType(row.getCell(i)));
            }
            mapList.add(map);
        }
        return mapList;
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
    public static List<List> excelDataNotHeader(MultipartFile file) {
        Sheet sheet = null;
        try {
            sheet = getWorkBook(file).getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建接收集的集合
        List<List> mapList = new ArrayList<>();
        for (int x = 0; x < sheet.getLastRowNum(); x ++ ){
            List list = new ArrayList<>();
            Row row = sheet.getRow(x + 1);
            for (int i = 0; i < row.getRowNum(); i ++ ) {
                list.add(excelDataType(row.getCell(i)));
            }
            mapList.add(list);
        }
        return mapList;
    }

    /**
     * 筛选表中数据的格式
     */
    public static String excelDataType(Cell cell) {
        return getDataType(cell, numberFormat);
    }

    public static String getDataType(Cell cell, NumberFormat numberFormat) {
        if (cell == null){
            return null;
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
    public static Workbook getWorkBook(MultipartFile file) throws IOException {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件格式
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        //判断文件格式
//        if (!fileType.equals("xls") && !fileType.equals("xlsx")) {
//            throw new CommonException(ErrorCode.FILE_FORMAT_ERROR);
//        }
        //读取文件
        InputStream inputStream = file.getInputStream();
        //03及以下excel版本
        if ("xls".equals(fileType)) {
            return new HSSFWorkbook(inputStream);
        }
        //07及以上excel版本
        return new XSSFWorkbook(inputStream);
    }
}
