package christmas.domain.discount;

import christmas.domain.VisitDate;

public class ChristmasEvent {

    private final static int ChristmasDiscountRate = 100;
    private final static int CHRISTMAS_DISCOUNT_START_DATE = 1;
    private final static int CHRISTMAS_DISCOUNT_END_DATE = 25;
    private int christmasDiscountPrice;

    public ChristmasEvent(VisitDate visitDate) {
        this.christmasDiscountPrice = notDiscountPeriod(visitDate);
    }

    private int notDiscountPeriod(VisitDate visitDate) {
        christmasDiscountPrice = 0;
        if (isDiscountPeriod(visitDate)) {
            calculateChristmasDiscount(visitDate);
        }
        return christmasDiscountPrice;
    }

    private boolean isDiscountPeriod(VisitDate visitDate) {
        return visitDate.getVisitDate() >= CHRISTMAS_DISCOUNT_START_DATE
                && visitDate.getVisitDate() <= CHRISTMAS_DISCOUNT_END_DATE;
    }

    private void calculateChristmasDiscount(VisitDate visitDate) {
        christmasDiscountPrice = 1000;
        for (int i = 1; i < visitDate.getVisitDate(); i++) {
            christmasDiscountPrice += ChristmasDiscountRate;
        }
    }

    public int getChristmasDiscountPrice(){
        return christmasDiscountPrice;
    }

}

