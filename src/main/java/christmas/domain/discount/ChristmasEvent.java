package christmas.domain.discount;

public class ChristmasEvent {

    private final static int ChristmasDiscountRate = 100;
    private final static int CHRISTMAS_DISCOUNT_START_DATE = 1;
    private final static int CHRISTMAS_DISCOUNT_END_DATE = 25;
    private int christmasDiscountPrice;

    public ChristmasEvent(int visitDate) {
        this.christmasDiscountPrice = notDiscountPeriod(visitDate);
    }

    private int notDiscountPeriod(int visitDate) {
        christmasDiscountPrice = 0;
        if (isDiscountPeriod(visitDate)) {
            calculateChristmasDiscount(visitDate);
        }
        return christmasDiscountPrice;
    }

    private boolean isDiscountPeriod(int visitDate) {
        return visitDate >= CHRISTMAS_DISCOUNT_START_DATE
                && visitDate <= CHRISTMAS_DISCOUNT_END_DATE;
    }

    private void calculateChristmasDiscount(int visitDate) {
        christmasDiscountPrice = 1000;
        for (int i = 1; i < visitDate; i++) {
            christmasDiscountPrice += ChristmasDiscountRate;
        }
    }

    public int getChristmasDiscountPrice(){
        return christmasDiscountPrice;
    }

}

