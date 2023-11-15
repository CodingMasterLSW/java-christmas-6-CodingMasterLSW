package christmas.domain;


import christmas.constant.StoreMenu;

public class MenuOrder {

    private final String menu;
    private final int quantity;

    public MenuOrder(String menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;

    }

    public int calculatePrice() {
        return StoreMenu.getPriceOf(menu) * quantity;
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }


}
