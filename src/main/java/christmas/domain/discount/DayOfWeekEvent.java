package christmas.domain.discount;

import static christmas.constant.StoreMenu.DESSERT_MENU;
import static christmas.constant.StoreMenu.MAIN_MENU;

import christmas.domain.MenuOrder;
import christmas.utils.DayOfWeekUtils;
import java.util.Arrays;
import java.util.List;

public class DayOfWeekEvent {

    private final static int DAY_DISCOUNT_RATE = 2023;
    private int count;
    private int weekDayDiscount;
    private int weekendDiscount;
    private DayOfWeekUtils dayOfWeekUtils = new DayOfWeekUtils();

    public DayOfWeekEvent(int visitDate, List<MenuOrder> menuOrders) {
        this.weekDayDiscount = 0;
        this.weekendDiscount = 0;
        applyDiscount(visitDate, menuOrders);
    }

    private void applyDiscount(int visitDate, List<MenuOrder> menuOrders) {
        weekendDiscount(visitDate, menuOrders);
        weekdayDiscount(visitDate, menuOrders);
    }

    private void weekendDiscount(int visitDate, List<MenuOrder> menuOrders) {
        if (DayOfWeekUtils.isWeekend(visitDate)) {
            count = 0;
            findAllContainsMainMenu(menuOrders);
            weekendDiscount += calculateWeekendDiscount();
        }
    }

    private void weekdayDiscount(int visitDate, List<MenuOrder> menuOrders) {
        if (!DayOfWeekUtils.isWeekend(visitDate)) {
            count = 0;
            findAllContainsDessertMenu(menuOrders);
            weekDayDiscount += calculateWeekendDiscount();
        }
    }

    private void findAllContainsMainMenu(List<MenuOrder> menuOrders) {
        for (MenuOrder order : menuOrders) {
            findMainMenu(order);
        }
    }

    private void findAllContainsDessertMenu(List<MenuOrder> menuOrders) {
        for (MenuOrder order : menuOrders) {
            findDessertMenu(order);
        }
    }


    private void findMainMenu(MenuOrder order) {
        if (Arrays.asList(MAIN_MENU.getStoreMenus()).contains(order.getMenu())) {
            count += order.getQuantity();
        }
    }

    private void findDessertMenu(MenuOrder order) {
        if (Arrays.asList(DESSERT_MENU.getStoreMenus()).contains(order.getMenu())) {
            count += order.getQuantity();
        }
    }

    private int calculateWeekendDiscount() {
        return count * DAY_DISCOUNT_RATE;
    }

    public int getWeekDayDiscount() {
        return weekDayDiscount;
    }
    public int getWeekendDiscount(){
        return weekendDiscount;
    }

}
