package kr.co.himedia.minipro;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoiExcelWriteTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<MemberDTO> members = new ArrayList<>();

        while (true) {
            System.out.print("이름을 입력하세요 : ");
            String name = scanner.nextLine();

            if (name.equals("quit")) {
                break;
            }

            System.out.print("나이를 입력하세요 : ");
            int age = scanner.nextInt();

            //개행문자 제거
            scanner.nextLine();

            MemberDTO memberDTO = new MemberDTO(name, age);
            members.add(memberDTO);

        }

        scanner.close();

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("회원 정보");

        // 헤더 생성
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("이름");
        headerRow.createCell(1).setCellValue("나이");

        // 데이터 생성
        for(int i=0; i < members.size(); i++) {
            MemberDTO memberDTO = members.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(memberDTO.getName());
        }

        String filename = "poiMember.xlsx";
        try {
            FileOutputStream fos = new FileOutputStream(new File(filename));
            workbook.write(fos);
            workbook.close();
            System.out.println("엑셀 파일이 저장되었습니다 :  " + filename);

        } catch (IOException e) {
            System.out.println("엑셀 파일 저장 중 오류가 발생했습니다.");
            throw new RuntimeException(e);
        }

    }
}
























