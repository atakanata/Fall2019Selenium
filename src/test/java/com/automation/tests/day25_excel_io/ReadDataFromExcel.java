package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws IOException {
        File file = new File("VytrackTestUsers.xlsx");

        Workbook workbook = WorkbookFactory.create(file);
        Sheet workSheet = workbook.getSheet("QA1-short");
        Row firstRow = workSheet.getRow(0);
        Cell firstCell = firstRow.getCell(0);

        String value = firstCell.getStringCellValue();
        //System.out.println("value = " + value);

        String secondCellValue = firstRow.getCell(1).getStringCellValue();
        //System.out.println("secondCellValue = " + secondCellValue);

//        int lastCell = firstRow.getLastCellNum();
//        for (int i = 0; i <lastCell; i++) {
//            System.out.print(firstRow.getCell(i)+" | ");
//        }

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }

    }

    @Test
    public void excelUtilityTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

        //System.out.println(excelUtil.getDataList());
                       // p -> System.out.println(p)
        excelUtil.getDataList().forEach(System.out::println);
    }

    @Test
    public void getColumnNamesTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

        System.out.println(excelUtil.getColumnsNames());
    }
}
