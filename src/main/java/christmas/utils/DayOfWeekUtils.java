package christmas.utils;

import christmas.domain.VisitDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekUtils {

    private final static int YEAR = 2023;
    private final static int MONTH = 12;

    public static boolean isWeekend(VisitDate visitDate) {
        LocalDate date = LocalDate.of(YEAR, MONTH, visitDate.getVisitDate());
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

}
