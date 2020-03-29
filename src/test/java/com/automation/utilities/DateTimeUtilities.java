package com.automation.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilities {

    /**
     * This method returns current date as a string.
     * Provide a format as a parameter
     *
     * MM - to specify month like: 01, 02, 03,
     * MMM - to specify month like: Jan, Feb, Mar
     *
     * dd - to specify day, like 01, 02, 03
     *
     * yyyy - to specify year like: 2010, 2020
     *
     * @param format for example: MMM dd, yyyy = Mar 29, 2020
     * @return current date as a string
     *
     * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
     */
    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }
}
