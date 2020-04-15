package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);//2nd row
        Cell cell = row.getCell(row.getLastCellNum() - 1);//last column

        System.out.println("Before: " + cell.getStringCellValue());
        cell.setCellValue("FAILED");//I am changing from n/a to passed
        System.out.println("After: " + cell.getStringCellValue());

        Row firstRow = sheet.getRow(0);


        //I crete if I want to write something into the file
        //don't forget to close excel file if you opened it
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);//write changes
        workbook.close();//close when everything is done
        outputStream.close();
        /**
         * Close the underlying input resource (File or Stream),
         *  from which the Workbook was read.
         *
         * <p>Once this has been called, no further
         *  operations, updates or reads should be performed on the
         *  Workbook.
         */
    }
}
