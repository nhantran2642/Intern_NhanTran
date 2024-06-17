package com.nhantran.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static String calculateNextDate(int numberOfNextDays) {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = currentDate.plusDays(numberOfNextDays);
        return nextDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
    }
}
