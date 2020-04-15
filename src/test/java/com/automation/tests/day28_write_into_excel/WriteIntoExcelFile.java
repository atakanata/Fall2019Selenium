package com.automation.tests.day28_write_into_excel;

import com.automation.utilities.DateTimeUtilities;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("QA3-short");
        Row firstRow = sheet.getRow(0);
        Cell cell = firstRow.getCell(5);
        System.out.println(cell.getStringCellValue());
        cell.setCellValue("PASSED");

        Cell newCell = firstRow.createCell(6);
        newCell.setCellValue("Date of execution");

        Row secondRow = sheet.getRow(1);
        Cell newCell2 = secondRow.createCell(6);
        newCell2.setCellValue(DateTimeUtilities.getCurrentDate("MMM d, yyyy"));

        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
