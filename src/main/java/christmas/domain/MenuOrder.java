package christmas.domain;


public class MenuOrder {

    private final String menu;
    private final int quantity;

    public MenuOrder(String menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;

    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }


}
