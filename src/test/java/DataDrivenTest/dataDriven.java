package DataDrivenTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven
{
    // identify testcases column by scanning entire first row
    // identify test cases which you want
    //  Pull  all data from row and feed in to test
    /**
     * First create object for  workbook it accepts file as FileInputStream so
     * Create object for FileInputStream and paste the excel path ..... This is for accessing work book
     * Accessing sheet :
     *
     * @return
     */

    public ArrayList<String> getData(String testCaseName,String sheetName) throws Exception
    {
        ArrayList<String> a = new ArrayList<>();
        //File input stream arguments
        FileInputStream file = new FileInputStream("/Users/spare/Downloads/DemoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int count = workbook.getNumberOfSheets();
        System.out.println(count);
        for (int i = 0; i < 3; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                // identify testcases column by scanning entire first row
                Iterator<Row> rows = sheet.iterator();
                Row FirstRow = rows.next();
                Iterator<Cell> cell = FirstRow.cellIterator();
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell val = cell.next();
                    if (val.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        //desired column
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);
                // identify test cases which you want
                while (rows.hasNext())
                {
                    Row row = rows.next();
                    if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        //Pull  all data from row and feed in to test
                        Iterator<Cell> ce = row.cellIterator();
                        while (ce.hasNext())
                        {
                          Cell c=ce.next();
                          if (c.getCellType()== CellType.STRING)
                          {
                            a.add(c.getStringCellValue());
                           }
                          else
                          {
                              a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                          }
                          }

                        return a;
                       }
                }
            }
        }
        return a;
    }
            public static void main (String[]args)
            {

            }


}


