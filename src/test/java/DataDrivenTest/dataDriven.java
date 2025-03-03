//package DataDrivenTest;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.util.NumberToTextConverter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class dataDriven
//{
//    // identify testcases column by scanning entire first row
//    // identify test cases which you want
//    //  Pull  all data from row and feed in to test
//    /**
//     * First create object for  workbook it accepts file as FileInputStream so
//     * Create object for FileInputStream and paste the excel path ..... This is for accessing work book
//     * Accessing sheet :
//     *
//     * @return
//     */
//
//    public ArrayList<String> getData(String testCaseName,String sheetName) throws Exception
//    {
//        ArrayList<String> a = new ArrayList<>();
//        //File input stream arguments
//        FileInputStream file = new FileInputStream("/Users/spare/Downloads/DemoData.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        int count = workbook.getNumberOfSheets();
//        System.out.println(count);
//        for (int i = 0; i < 3; i++) {
//            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
//                XSSFSheet sheet = workbook.getSheetAt(i);
//                // identify testcases column by scanning entire first row
//                Iterator<Row> rows = sheet.iterator();
//                Row FirstRow = rows.next();
//                Iterator<Cell> cell = FirstRow.cellIterator();
//                int k = 0;
//                int column = 0;
//                while (cell.hasNext()) {
//                    Cell val = cell.next();
//                    if (val.getStringCellValue().equalsIgnoreCase("TestCases")) {
//                        //desired column
//                        column = k;
//                    }
//                    k++;
//                }
//                System.out.println(column);
//                // identify test cases which you want
//                while (rows.hasNext())
//                {
//                    Row row = rows.next();
//                    if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
//                        //Pull  all data from row and feed in to test
//                        Iterator<Cell> ce = row.cellIterator();
//                        while (ce.hasNext())
//                        {
//                          Cell c=ce.next();
//                          if (c.getCellType()== CellType.STRING)
//                          {
//                            a.add(c.getStringCellValue());
//                           }
//                          else
//                          {
//                              a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
//                          }
//                          }
//
//                        return a;
//                       }
//                }
//            }
//        }
//        return a;
//    }
//
//    public static void main(String[] args)
//    {
//
//    }
//
//}
//
//

package DataDrivenTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public ArrayList<String> getData(String testCaseName, String sheetName) throws IOException {
        ArrayList<String> a = new ArrayList<>();

        // Use try-with-resources to ensure file is closed properly
        try (FileInputStream file = new FileInputStream("/Users/spare/Downloads/DemoData.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            int sheetCount = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetCount; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                    XSSFSheet sheet = workbook.getSheetAt(i);

                    // Identify test cases column by scanning the first row
                    Iterator<Row> rows = sheet.iterator();
                    if (!rows.hasNext()) {
                        throw new IllegalStateException("Sheet is empty!");
                    }
                    Row firstRow = rows.next();
                    Iterator<Cell> cells = firstRow.cellIterator();

                    int k = 0, column = -1;
                    while (cells.hasNext()) {
                        Cell cell = cells.next();
                        if (cell.getCellType() == CellType.STRING &&
                                cell.getStringCellValue().equalsIgnoreCase("TestCases")) {
                            column = k;
                            break;
                        }
                        k++;
                    }

                    if (column == -1) {
                        throw new IllegalStateException("'TestCases' column not found!");
                    }

                    // Find the row with the test case name
                    while (rows.hasNext()) {
                        Row row = rows.next();
                        Cell testCaseCell = row.getCell(column);
                        if (testCaseCell != null && testCaseCell.getCellType() == CellType.STRING &&
                                testCaseCell.getStringCellValue().equalsIgnoreCase(testCaseName)) {

                            Iterator<Cell> rowCells = row.cellIterator();
                            while (rowCells.hasNext()) {
                                Cell c = rowCells.next();

                                // Skip the first cell (test case name)
                                if (c.getColumnIndex() == column) {
                                    continue;
                                }

                                if (c.getCellType() == CellType.STRING) {
                                    a.add(c.getStringCellValue());
                                } else if (c.getCellType() == CellType.NUMERIC) {
                                    a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                                }
                            }
                            return a;  // Return the row data once found
                        }
                    }
                }
            }
        }
        return a;
    }
}

