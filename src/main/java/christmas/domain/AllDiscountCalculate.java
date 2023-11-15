package christmas.domain;

import christmas.domain.discount.ChristmasEvent;
import christmas.domain.discount.DateOfStarsEvent;
import christmas.domain.discount.DayOfWeekEvent;
import java.util.List;

public class AllDiscountCalculate {

    private static final int CHRISTMAS_DATE = 25;
    private static final int MINIMUM_DISCOUNT_CONDITIONS = 10000;
    private int allDiscountPrice;
    private int christmasDatePrice;
    private int dayOfWeekendPrice;
    private int dayOfWeekdayPrice;
    private int specialPrice;
    private ChristmasEvent christmasEvent;
    private DayOfWeekEvent dayOfWeekEvent;
    private DateOfStarsEvent dateOfStarsEvent;

    public AllDiscountCalculate(VisitDate visitDate, int totalPrice, List<MenuOrder> menuOrders) {

        initializeEvents(visitDate, menuOrders);
        minimumDiscountConditions(totalPrice, visitDate);
    }

    private void initializeEvents(final VisitDate visitDate, final List<MenuOrder> menuOrders) {
        this.christmasEvent = new ChristmasEvent(visitDate);
        this.dayOfWeekEvent = new DayOfWeekEvent(visitDate, menuOrders);
        this.dateOfStarsEvent = new DateOfStarsEvent(visitDate);
    }

    private void minimumDiscountConditions(final int totalPrice, final VisitDate visitDate) {
        if (totalPrice >= MINIMUM_DISCOUNT_CONDITIONS) {
            calculateDiscounts(visitDate);
        }
    }

    private void calculateDiscounts(VisitDate visitDate) {
        if (visitDate.getVisitDate() <= CHRISTMAS_DATE) {
            christmasDatePrice += christmasEvent.getChristmasDiscountPrice();
        }
        specialPrice += dateOfStarsEvent.getTotalDiscount();
        dayOfWeekdayPrice += dayOfWeekEvent.getWeekDayDiscount();
        dayOfWeekendPrice += dayOfWeekEvent.getWeekendDiscount();
        allDiscountPrice =
                christmasDatePrice + specialPrice + dayOfWeekdayPrice + dayOfWeekendPrice;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public int getChristmasDatePrice() {
        return christmasDatePrice;
    }

    public int getDayOfWeekdayPrice() {
        return dayOfWeekdayPrice;
    }

    public int getDayOfWeekendPrice() {
        return dayOfWeekendPrice;
    }

    public int getAllDiscountPrice() {
        return allDiscountPrice;
    }
}