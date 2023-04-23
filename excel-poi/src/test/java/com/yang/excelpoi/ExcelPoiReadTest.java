package com.yang.excelpoi;

import com.alibaba.excel.util.IoUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/09/19/16:03
 */
public class ExcelPoiReadTest {

    public static final String PATH = "/Users/yang/IdeaProjects/SoftLeaderGy/test-demo/test-demo/excel-poi/";

    /**
     * 03Excel测试读数据
     */
    @Test
    @SneakyThrows
    public void excel03ReadTest(){
        FileInputStream fileInputStream = new FileInputStream(PATH + "测试写入excel数据.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheetAt = workbook.getSheetAt(0);
        HSSFRow row = sheetAt.getRow(0);
        HSSFCell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
    }


    /**
     * 07Excel测试读数据
     */
    @Test
    @SneakyThrows
    public void excel07ReadTest(){
        FileInputStream fileInputStream = new FileInputStream(PATH + "测试写入excel数据.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        XSSFRow row = sheetAt.getRow(0);
        XSSFCell cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());
    }


    /**
     * 07Excel测试读数据
     */
    @Test
    @SneakyThrows
    public void testCellType(){
        FileInputStream fileInputStream = new FileInputStream(PATH + "测试写入excel数据.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        XSSFRow rowTitle = sheetAt.getRow(0);
        int cellNum = rowTitle.getPhysicalNumberOfCells();
        for (int i = 0; i < cellNum; i++) {
            XSSFCell cell = rowTitle.getCell(i);
            if (cell != null) {
                CellType cellType = cell.getCellType();
                String stringCellValue = cell.getStringCellValue();
                System.out.print(stringCellValue + " | ");
            }
        }
        System.out.println();
        // 读数据
        // 获取excel行数
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum < physicalNumberOfRows; rowNum++) {
            XSSFRow rowData = sheetAt.getRow(rowNum);
            if (rowData != null) {
                int cellCount = rowData.getPhysicalNumberOfCells();
                for (int i = 0; i < cellCount; i++) {
                    XSSFCell cell = rowData.getCell(i);
                    if (cell != null) {
                        String cellValue="";
                        CellType cellType = cell.getCellType();
                        switch (cellType){
                            case STRING:cellValue = cell.getStringCellValue();
                                break;//string类型
                            case BOOLEAN:cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;//布尔类型
                            case NUMERIC:
                                if (HSSFDateUtil.isCellDateFormatted(cell)){
                                    Date dateCellValue = cell.getDateCellValue();
                                    cellValue = new DateTime().toString("yyyy-MM-dd");
                                    break;
                                } else {
                                    // 数字以字符串的形式进行输出
                                    cell.setCellType(CellType.STRING);
                                    cellValue = cell.getStringCellValue();
                                    break;
                                }
                        }
                        System.out.print(cellValue + " | ");
                    }
                }
            }
        }
        fileInputStream.close();
    }
    @Test
    @SneakyThrows
    public void test(){
        ClassPathResource resource = new ClassPathResource("file/1.jpg");
        String absolutePath = resource.getFile().getAbsolutePath();
        System.out.println(absolutePath);
        FileInputStream fileInputStream = new FileInputStream(absolutePath);
//        OutputStream outputStream = new FileOutputStream(resource.getFile());
//        IOUtils.copy(fileInputStream,outputStream);
        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        System.out.println(bytes.toString());
    }

}
