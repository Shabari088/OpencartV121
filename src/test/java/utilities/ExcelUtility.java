package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileOutputStream fileOutput;
	public static FileInputStream fileInput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String xlsheet) throws IOException {

		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		int rowCount = worksheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowCount;
	}

	public int getCellCount(String xlsheet, int rownum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		row = worksheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellCount;
	}

	public String getCellData(String xlsheet, int rownum, int cellnum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		row = worksheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;
		try {

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}

		workbook.close();
		fileInput.close();
		return data;
	}

	public void setCellData(String xlsheet, int rownum, int cellnum, String data) throws IOException {
		File xlFile = new File(path);
		if (!xlFile.exists()) {
			workbook = new XSSFWorkbook();
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
		}

		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);

		if (workbook.getSheetIndex(xlsheet) == -1)
			workbook.createSheet(xlsheet);
		worksheet = workbook.getSheet(xlsheet);

		if (worksheet.getRow(rownum) == null)
			worksheet.createRow(rownum);
		row = worksheet.getRow(rownum);

		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();

	}

	public void setCellColor(String xlsheet, int rownum, int cellnum, String data) throws IOException {

		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		row = worksheet.getRow(rownum);
		cell = row.getCell(cellnum);
		style = workbook.createCellStyle();

		if (data.equals("Pass")) {
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		} else {
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}

		cell.setCellStyle(style);
		fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();

	}

}
