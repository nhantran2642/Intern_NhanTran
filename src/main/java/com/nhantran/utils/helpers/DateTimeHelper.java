package com.nhantran.utils.helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static String calculateNextDate(int numberOfNextDays) {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDate = currentDate.plusDays(numberOfNextDays);
        return nextDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
    }

    public static String generateCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
    }
}
