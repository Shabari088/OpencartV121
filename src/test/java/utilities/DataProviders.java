package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException {

		String path = "./testData//Opencart_LoginData.xlsx";

		ExcelUtility excelUtil = new ExcelUtility(path);

		int totalrows = excelUtil.getRowCount("Sheet1");
		int totalcols = excelUtil.getCellCount("Sheet1", totalrows);

		Object loginData[][] = new Object[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {

			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = excelUtil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

}
