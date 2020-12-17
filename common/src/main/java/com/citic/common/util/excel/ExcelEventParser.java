package com.citic.common.util.excel;

import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelEventParser {
    private String fileName;
    private SimpleSheetContentsHandler handler;
    private InputStream inputStream;
    private OPCPackage opcPackage;
    protected List h = new LinkedList();
    protected List<List<Map<Object,String>>> table = new ArrayList<>();

    private void setHandler(SimpleSheetContentsHandler handler) {
        this.handler = handler;
    }

    public ExcelEventParser(String filename) {
        try {
            this.opcPackage = OPCPackage.open(filename);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public ExcelEventParser(InputStream file)  {
        try {
            this.opcPackage = OPCPackage.open(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ExcelEventParser(MultipartFile file)  {
        try {
            this.opcPackage = OPCPackage.open(file.getInputStream());
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List getHead() {
        return h;
    }

    public List<List<Map<Object,String>>> parse() {
        InputStream inputStream = null;
        try {
            XSSFReader xssfReader = new XSSFReader(opcPackage);
            StylesTable styles = xssfReader.getStylesTable();
            ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(opcPackage);
            Iterator<InputStream> sheetsData = xssfReader.getSheetsData();
            while (sheetsData.hasNext()) {
                inputStream = sheetsData.next();
                processSheet(styles, strings, inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (opcPackage != null) {
                try {
                    opcPackage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return table;
    }

    /**
     * 确定XMLReader解析器，使用SAX模式解析xml文件
      */
    private void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, InputStream sheetInputStream) throws SAXException, ParserConfigurationException, IOException {
        XMLReader sheetParser = SAXHelper.newXMLReader();

        if (handler == null) {
            setHandler(new SimpleSheetContentsHandler());
        }
        sheetParser.setContentHandler(new XSSFSheetXMLHandler(styles, strings, handler, false));

        try {
            sheetParser.parse(new InputSource(sheetInputStream));
        } catch (RuntimeException e) {
            System.out.println("---> 遇到空行读取文件结束！");
        }
    }

    /**
     * 实现SheetContentsHandler
      */
    public class SimpleSheetContentsHandler implements SheetContentsHandler{
        protected List<Map<Object,String>> row;
        protected List head;
        protected Map map;
        @Override
        public void startRow(int rowNum) {
            map = new HashMap();
            head = new LinkedList<>();
            row = new LinkedList<>();
        }

        @Override
        public void endRow(int rowNum) {
            // 判断是否使用异常作为文件读取结束（有些Excel文件格式特殊，导致很多空行，浪费内存）
            if (row.isEmpty()) {
                throw new RuntimeException("Excel文件读取完毕");
            }
            // 添加数据到list集合
            addData(row);
        }

        /**
         * 所有单元格数据转换为string类型，需要自己做数据类型处理
         * @param cellReference 单元格索引
         * @param formattedValue 单元格内容（全部被POI格式化为字符串）
         * @param comment
         */
        @Override
        public void cell(String cellReference, String formattedValue, XSSFComment comment) {
            if (h.size() == 0) {
                head.add(formattedValue);
            }
            short col = new CellReference(cellReference).getCol();
            map.put(String.valueOf(col),formattedValue);
            row.add(map);
        }

        @Override
        public void headerFooter(String text, boolean isHeader, String tagName) {
        }

        public void addData(List row) {
            if (h.size() == 0) {
                if (head.size() > 5){
                    h = head;
                }
                return;
            }else {
                table.add(row);
            }
        }

    }


}

