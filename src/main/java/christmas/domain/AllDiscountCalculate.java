package christmas.domain;

import christmas.domain.discount.ChristmasEvent;
import christmas.domain.discount.DateOfStarsEvent;
import christmas.domain.discount.DayOfWeekEvent;
import java.util.List;

public class AllDiscountCalculate {

    private static final int CHRISTMAS_DATE = 25;
    private static final int MINIMUM_DISCOUNT_CONDITIONS = 10000;
    private int allDiscountPrice;

    private ChristmasEvent christmasEvent;
    private DayOfWeekEvent dayOfWeekEvent;
    private DateOfStarsEvent dateOfStarsEvent;

    public AllDiscountCalculate(int visitDate, int totalPrice, List<MenuOrder> menuOrders) {

        initializeEvents(visitDate, menuOrders);
        minimumDiscountConditions(totalPrice, visitDate);
    }

    private void initializeEvents(int visitDate, List<MenuOrder> menuOrders) {
        this.christmasEvent = new ChristmasEvent(visitDate);
        this.dayOfWeekEvent = new DayOfWeekEvent(visitDate, menuOrders);
        this.dateOfStarsEvent = new DateOfStarsEvent(visitDate);
    }

    private void minimumDiscountConditions(int totalPrice, int visitDate) {
        if (totalPrice >= MINIMUM_DISCOUNT_CONDITIONS) {
            calculateDiscounts(visitDate);
        }
    }

    private void calculateDiscounts(int visitDate) {
        if (visitDate <= CHRISTMAS_DATE) {
            allDiscountPrice += christmasEvent.getChristmasDiscountPrice();
        }
        allDiscountPrice += dateOfStarsEvent.getTotalDiscount();
        allDiscountPrice += dayOfWeekEvent.getWeekDayDiscount();
        allDiscountPrice += dayOfWeekEvent.getWeekendDiscount();
    }


    public int getAllDiscountPrice() {
        return allDiscountPrice;
    }
}