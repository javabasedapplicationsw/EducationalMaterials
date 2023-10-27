package kr.co.himedia.minipro;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    POI 라이브러리 사용하여 Excel 파일 읽기
        - 엑셀파일 오픈
        - 첫번째 시트 읽기
        - 시트안의 각각 row를 읽기
        - row안의 각각 셀 읽기
        - 셀값 출력하기
 */
public class PoiExcelTest {
    public static void main(String[] args) {
        try {
            FileInputStream fis =  new FileInputStream(new File("poiSample.xlsx"));

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row)
                    //System.out.print(cell.toString() + "\t");
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                Date dateValue = cell.getDateCellValue();
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String formattedDate = dateFormat.format(dateValue);
                                System.out.print(formattedDate + "\t");
                            } else {
                                double numericValue = cell.getNumericCellValue();
                                if (numericValue == Math.floor(numericValue)) {
                                    int intValue = (int) numericValue;
                                    System.out.print(intValue + "\t");
                                } else {
                                    System.out.print(numericValue + "\t");          //35.7 != 35.0
                                }
                            }
                            break;
                        case STRING:
                            String stringValue = cell.getStringCellValue();
                            System.out.print(stringValue + "\t");
                            break;
                        case BOOLEAN:
                            boolean booleanValue = cell.getBooleanCellValue();
                            System.out.print(booleanValue + "\t");
                            break;
                        default:
                            System.out.print("\t");
                            break;
                    }
                System.out.println();
            }
            fis.close();
            System.out.println("엑셀파일에서 데이터 읽어오기 success!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


















