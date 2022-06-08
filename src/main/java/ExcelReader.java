import java.io.*;
import java.net.URL;
import java.util.Enumeration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.*;

public class ExcelReader {
    public static final String NonCommunityResultFile = ".\\nonCommuityDeployments.txt";

    public void SearchForNonCommunity(String clusterIds) throws IOException {

        String[] Ids = clusterIds.split(",");


        File result = new File(NonCommunityResultFile);
        if (result.exists() == false) {
            System.out.println("Creating a result file for non community deployments");
            result.createNewFile();
        }

        PrintWriter out = new PrintWriter(new FileWriter(result, true));
        File file = new File("");


        Enumeration<URL> is = this.getClass().getClassLoader().getResources("file.txt");
        FileInputStream inputStream = new FileInputStream(is.toString());
        try (Workbook wb = new HSSFWorkbook(inputStream)) {
            //Read sheet inside the workbook by its name
            Sheet sh = wb.getSheet("");
            //Find number of rows in excel file
            int lastRow = sh.getPhysicalNumberOfRows();

            int lastColumn = sh.getRow(0).getLastCellNum();

            String[][] excelData = new String[lastRow][lastColumn];

            for (int r = 0; r < lastRow; r++) {

                for (int c = 0; c < lastColumn; c++) {
                    Row row = sh.getRow(r);
                    excelData[r][c] = row.getCell(c).getStringCellValue();
                }

            }


            String[][] isCommunity = new String[lastRow][1];

            for (String str : Ids) {

                for (int row = 0; row < lastRow; row++) {

                    isCommunity[row][0] = excelData[row][2];

                    if (isCommunity[row][0].toString().equals(str)) {

                        // Do Nothing
                    }

                    else {
                        for (int col = 0; col < lastColumn; col++) {

                            System.out.println(excelData[row][col]);

                        }

                        // System.out.println(isExecuted[row][0]);

                    }

                }

            }


        }


    }

    public static void main (String args[]) throws IOException {
        ExcelReader excelReader = new ExcelReader();
        excelReader.SearchForNonCommunity("20,77,86");
    }

}
