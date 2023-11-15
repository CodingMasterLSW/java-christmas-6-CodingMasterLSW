package christmas.domain.discount;

import christmas.domain.VisitDate;

public class ChristmasEvent {

    private static final int ChristmasDiscountRate = 100;
    private static final int CHRISTMAS_DISCOUNT_START_DATE = 1;
    private static final int CHRISTMAS_DISCOUNT_END_DATE = 25;
    private static final int CHRISTMAS_SETTING_DISCOUNT_PRICE = 1000;
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
        christmasDiscountPrice = CHRISTMAS_SETTING_DISCOUNT_PRICE;
        for (int i = 1; i < visitDate.getVisitDate(); i++) {
            christmasDiscountPrice += ChristmasDiscountRate;
        }
    }

    public int getChristmasDiscountPrice() {
        return christmasDiscountPrice;
    }

}

