package christmas.domain;

import christmas.constant.StoreMenu;

public class GiftMenu {

    private static final String GIFT_MENU_NAME = "샴페인";
    private static final int PRESENT_CONDITION = 120000;
    private String name;
    private int price;
    private int quantity;

    public GiftMenu(int totalPrice) {
        this.name = null;
        this.price = 0;
        this.quantity = 0;
        giftMenuEvent(totalPrice);

    }

    private void giftMenuEvent(int totalPrice) {
        if (totalPrice >= PRESENT_CONDITION) {
            this.name = GIFT_MENU_NAME;
            this.price = StoreMenu.getPriceOf(name);
            this.quantity = 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price * quantity;
    }

    public int getQuantity() {
        return quantity;
    }


}
