package org.camunda.bpm.getstarted.loanapproval.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class ConvertDateTimeUtils {

    private static final String UTC_MOSCOW = "UTC+3";
    private static final int MIN_HOUR_JOB_DAY = 9;
    private static final int MAX_HOUR_JOB_DAY = 18;


    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.of(UTC_MOSCOW))
                .toLocalDateTime();
    }

    public static Date convertToDate(LocalDateTime dateToConvert) {
        return Date
                .from(dateToConvert.atZone(ZoneId.of(UTC_MOSCOW))
                        .toInstant());
    }

    public static LocalDateTime getWorkTime(LocalDateTime localDateTime) {
        System.out.println("Проверка Времени: Начато");
        LocalDateTime result = localDateTime;
        int dayHour = result.getHour();

        if (dayHour <= MIN_HOUR_JOB_DAY || dayHour >= MAX_HOUR_JOB_DAY) {
            dayHour = MAX_HOUR_JOB_DAY;
            System.out.println("Проверка Времени: Закончена = " + dayHour);
            return result.withHour(dayHour).withMinute(0).withSecond(0);
        }
        System.out.println("Проверка Времени: Закончена = " + dayHour);
        return result;
    }
}
