package com.naveenautomation.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xfile, String sheetName) throws IOException {

		int rowCount = 0;
		fi = new FileInputStream(xfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		rowCount = ws.getLastRowNum();

		wb.close();
		fi.close();

		return rowCount;

	}

	public static int getColumnCount(String xfile, String sheetName, int rowNo) throws IOException {

		int colCount = 0;
		fi = new FileInputStream(xfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		colCount = row.getLastCellNum();

		wb.close();
		fi.close();

		return colCount;

	}

	public static String getCellValue(String xfile, String sheetName, int rowNo, int colCount) throws IOException {

		String data = "";
		fi = new FileInputStream(xfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colCount);
		data = new DataFormatter().formatCellValue(cell);

		wb.close();
		fi.close();

		return data;

	}

}
