package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "//TestData//UserData.xlsx";
		XLUtility xl = new XLUtility(path);

		int rowNum = xl.getRowCount("Sheet1");
		int columnCount = xl.getCellCount("Sheet1", 1);

		String apiData[][] = new String[rowNum][columnCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < columnCount; j++) {
				apiData[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return apiData;

	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {

		String path = System.getProperty("user.dir") + "//TestData//UserData.xlsx";
		XLUtility xl = new XLUtility(path);

		int rowNum = xl.getRowCount("Sheet1");

		String apiData[] = new String[rowNum];

		for (int i = 1; i <= rowNum; i++) {
			apiData[i - 1] = xl.getCellData("Sheet1", i, 1);
		}
		return apiData;
	}

}
