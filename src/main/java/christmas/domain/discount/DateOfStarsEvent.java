package christmas.domain.discount;

import christmas.domain.VisitDate;
import java.util.Arrays;
import java.util.List;

public class DateOfStarsEvent {

    private int totalDiscount;
    private final static int STAR_DISCOUNT_RATE = 1000;
    private final static List<Integer> STAR_DISCOUNT_DATE = Arrays.asList(3, 10, 17, 24, 25, 31);

    public DateOfStarsEvent(VisitDate visitDate) {
        this.totalDiscount = starDiscount(visitDate);
    }

    private int starDiscount(VisitDate visitDate) {
        int day = visitDate.getVisitDate();
        if (STAR_DISCOUNT_DATE.contains(day)) {
            totalDiscount += STAR_DISCOUNT_RATE;
        }
        return totalDiscount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}
