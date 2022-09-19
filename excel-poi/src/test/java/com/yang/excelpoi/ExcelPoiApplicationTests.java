package com.yang.excelpoi;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;

//@SpringBootTest
@Slf4j
class ExcelPoiApplicationTests {

	public static final String PATH = "/Users/yang/IdeaProjects/SoftLeaderGy/test-demo/test-demo/excel-poi";
	@Test
	void contextLoads() {
	}

	/**
	 * 测试excel03版写入数据
	 */
	@Test
	@SneakyThrows
	public void test03ExcelWrite(){
		// 创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("测试工作表01");
		// 创建一行数据（1，1）
		Row row1 = sheet.createRow(0);
		// 创建一个单员格
		Cell cell = row1.createCell(0);
		// 写入单元格数据
		cell.setCellValue("测试单元格");
		Cell cell12 = row1.createCell(1);
		cell12.setCellValue("123");
		// 创建第二行数据
		Row row2 = sheet.createRow(1);
		Cell cell1 = row2.createCell(0);
		cell1.setCellValue("时间");
		Cell cell2 = row2.createCell(1);
		cell2.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		// 创建文件流
		FileOutputStream fileOutputStream = new FileOutputStream(PATH + "/测试写入excel数据.xls");
		// 工作簿文件流写入
		workbook.write(fileOutputStream);
		// 关闭流
		fileOutputStream.close();
		log.info("文件生成完毕！");
	}


	/**
	 * 测试excel07版写入数据
	 */
	@Test
	@SneakyThrows
	public void test07ExcelWrite(){
		// 创建一个工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建一个工作表
		XSSFSheet sheet = workbook.createSheet("测试工作表01");
		// 创建一行数据（1，1）
		Row row1 = sheet.createRow(0);
		// 创建一个单员格
		Cell cell = row1.createCell(0);
		// 写入单元格数据
		cell.setCellValue("测试单元格");
		Cell cell12 = row1.createCell(1);
		cell12.setCellValue("123");
		// 创建第二行数据
		Row row2 = sheet.createRow(1);
		Cell cell1 = row2.createCell(0);
		cell1.setCellValue("时间");
		Cell cell2 = row2.createCell(1);
		cell2.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
		// 创建文件流
		FileOutputStream fileOutputStream = new FileOutputStream(PATH + "/测试写入excel数据.xlsx");
		// 工作簿文件流写入
		workbook.write(fileOutputStream);
		// 关闭流
		fileOutputStream.close();
		log.info("文件生成完毕！");
	}

}
