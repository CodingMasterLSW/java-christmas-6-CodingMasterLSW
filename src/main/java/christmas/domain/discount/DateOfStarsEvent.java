package christmas.domain.discount;

import java.util.Arrays;
import java.util.List;

public class DateOfStarsEvent {

    private int totalDiscount;
    private final static int STAR_DISCOUNT_RATE = 1000;
    private final static List<Integer> STAR_DISCOUNT_DATE = Arrays.asList(3, 10, 17, 24, 25, 31);

    public DateOfStarsEvent(int visitDate) {
        this.totalDiscount = starDiscount(visitDate);
    }

    private int starDiscount(int visitDate) {
        if (STAR_DISCOUNT_DATE.contains(visitDate)) {
            totalDiscount += STAR_DISCOUNT_RATE;
        }
        return totalDiscount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}
