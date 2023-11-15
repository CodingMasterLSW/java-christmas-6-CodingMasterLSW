package christmas.utils;

import static christmas.constant.ValidateErrorMessage.EXCEED_MAXIMUM_MENU_QUANTITY;
import static christmas.constant.ValidateErrorMessage.INVALID_DATE;
import static christmas.constant.ValidateErrorMessage.INVALID_ORDER;
import static christmas.constant.ValidateErrorMessage.NOT_ONLY_DRINKS;

import christmas.constant.StoreMenu;
import christmas.domain.MenuOrder;
import christmas.domain.VisitDate;
import java.util.Arrays;
import java.util.List;

public class DomainValidator {

    private final static int DATE_START_NUM = 1;
    private final static int DATE_END_NUM = 31;
    private final static int MAXIMUM_MENU_QUANTITY = 20;
    private final List<String> drinkMenus = Arrays.asList(StoreMenu.DRINK_MENU.getStoreMenus());


    public void ensureValidVisitDate(int visitDate) {
        checkNumbersRange(visitDate);
    }

    private void checkNumbersRange(int visitDate) {
        if (visitDate < DATE_START_NUM || visitDate > DATE_END_NUM) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    public void ensureValidMenuOrders(List<MenuOrder> menus) {
        checkNoExistMenu(menus);
        checkDuplicateExistMenu(menus);
        ensureNotOnlyDrink(menus);
        checkMaxQuantityOver(menus);

    }

    private void checkDuplicateExistMenu(List<MenuOrder> menus) {
        long distinctMenuCount = menus.stream()
                .map(MenuOrder::getMenu)
                .distinct()
                .count();

        if (distinctMenuCount != menus.size()) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private void checkNoExistMenu(List<MenuOrder> menus) {
        List<String> allMenus = StoreMenuUtils.getAllMenus();

        for (MenuOrder order : menus) {
            validateMenuExists(order, allMenus);
        }
    }

    private void validateMenuExists(MenuOrder order, List<String> allMenus) {
        if (!allMenus.contains(order.getMenu())) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private void ensureNotOnlyDrink(List<MenuOrder> menus) {
        boolean allDrinks = menus.stream()
                .allMatch(order -> drinkMenus.contains(order.getMenu()));
        if(allDrinks){
            throw new IllegalArgumentException(NOT_ONLY_DRINKS);
        }
    }

    private void checkMaxQuantityOver(List<MenuOrder> menus) {
        long totalQuantity = menus.stream()
                .mapToInt(MenuOrder::getQuantity)
                .sum();
        if (totalQuantity > MAXIMUM_MENU_QUANTITY) {
            throw new IllegalArgumentException(EXCEED_MAXIMUM_MENU_QUANTITY);
        }
    }
}
