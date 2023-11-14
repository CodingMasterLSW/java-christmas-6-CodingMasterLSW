package christmas.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekUtils {

    private final static int YEAR = 2023;
    private final static int MONTH = 12;

    public static boolean isWeekend(int visitDate) {
        LocalDate date = LocalDate.of(YEAR, MONTH, visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

}
