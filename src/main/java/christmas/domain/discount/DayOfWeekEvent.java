package christmas.domain.discount;

import static christmas.constant.StoreMenu.DESSERT_MENU;
import static christmas.constant.StoreMenu.MAIN_MENU;

import christmas.utils.DayOfWeekUtils;
import java.util.Arrays;
import java.util.List;

public class DayOfWeekEvent {

    private final static int DAY_DISCOUNT_RATE = 2023;
    private int count;
    private int totalDayDiscount;
    private DayOfWeekUtils dayOfWeekUtils = new DayOfWeekUtils();

    public DayOfWeekEvent(int visitDate, List<String> menus) {
        this.totalDayDiscount = 0;
        applyDiscount(visitDate, menus);
    }

    private void applyDiscount(int visitDate, List<String> menus) {
        weekendDiscount(visitDate, menus);
        weekdayDiscount(visitDate, menus);
    }

    private void weekendDiscount(int visitDate, List<String> menus) {
        if (DayOfWeekUtils.isWeekend(visitDate)) {
            count = 0;
            findAllContainsMainMenu(menus);
            totalDayDiscount += calculateWeekendDiscount();
        }
    }

    private void weekdayDiscount(int visitDate, List<String> menus) {
        if (!DayOfWeekUtils.isWeekend(visitDate)) {
            count = 0;
            findAllContainsDessertMenu(menus);
            totalDayDiscount += calculateWeekendDiscount();
        }
    }

    private void findAllContainsMainMenu(List<String> menus) {
        for (String menuName : menus) {
            findMainMenu(menuName);
        }
    }

    private void findAllContainsDessertMenu(List<String> menus) {
        for (String menuName : menus) {
            findDessertMenu(menuName);
        }
    }


    private void findMainMenu(String menuName) {
        if (Arrays.asList(MAIN_MENU).contains(menuName)) {
            count += 1;
        }
    }

    private void findDessertMenu(String menuName) {
        if (Arrays.asList(DESSERT_MENU).contains(menuName)) {
            count += 1;
        }
    }

    private int calculateWeekendDiscount() {
        return count * DAY_DISCOUNT_RATE;
    }

    public int getTotalDiscount() {
        return totalDayDiscount;
    }

}
