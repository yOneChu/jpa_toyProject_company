package excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelTest {


    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("E:\\test.xlsx");

            System.out.println(fis);
            //HSSFWorkbook workbook = new HSSFWorkbook(fis);
            //HSSFSheet sheet = workbook.getSheetAt(0);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            int rowindex = 0;
            int columnindex = 0;

            XSSFSheet sheet = workbook.getSheetAt(0);


            int rows = sheet.getPhysicalNumberOfRows();

            System.out.println("row == " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
