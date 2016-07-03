package co.sabit.commons.utils;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class Dates {

    public static Date getFirstDayOfMonth() {
        return java.sql.Date.valueOf(LocalDate.now().withDayOfMonth(1));
    }

    public static Date getFirstDayOfWeek() {
        LocalDate now = LocalDate.now();
        TemporalField fieldISO = WeekFields.of(Locale.forLanguageTag("es-co")).dayOfWeek();
        return java.sql.Date.valueOf(now.with(fieldISO, 1));
    }

    public static Date getFirstDayOfWeek(Date date) {
        LocalDate now = new java.sql.Date(date.getTime()).toLocalDate();
        TemporalField fieldISO = WeekFields.of(Locale.forLanguageTag("es-co")).dayOfWeek();
        return java.sql.Date.valueOf(now.with(fieldISO, 1));
    }

    public static int getWeekOfMonth() {
        return Dates.getWeekOfMonth(new Date());
    }

    public static int getWeekOfMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.WEEK_OF_MONTH);
        return weekNumber;
    }

}
