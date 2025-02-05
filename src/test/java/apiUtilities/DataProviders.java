package apiUtilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "testData")
    public static Object[][] getAllData() throws IOException {
        String filePath = "/home/o290173@eads.ecomexpress.in/Documents/JAVA/PetStore/testData/UserData.xlsx";  // Path to your Excel file
        String sheetName = "Sheet1"; // Your sheet name

        XLUtility xlUtil = new XLUtility(filePath);
        int rowCount = xlUtil.getRowCount(sheetName);
        int colCount = xlUtil.getCellCount(sheetName, 0);

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // Skip header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = xlUtil.getCellData(sheetName, i, j);
            }
        }
        return data;
    }
    @DataProvider(name = "userName")
    public static Object[][] getUserName() throws IOException {
        String filePath = "/home/o290173@eads.ecomexpress.in/Documents/JAVA/PetStore/testData/UserData.xlsx";  // Excel file path
        String sheetName = "Sheet1"; // Sheet name

        XLUtility xlUtil = new XLUtility(filePath);
        int rowCount = xlUtil.getRowCount(sheetName);

        Object[][] data = new Object[rowCount - 1][1]; // Only 1 column for usernames

        for (int i = 1; i < rowCount; i++) { // Skip header row
            data[i - 1][0] = xlUtil.getCellData(sheetName, i, 1); // Fetch only the first column (username)
        }
        return data;
    }

}
