package christmas.domain;

import java.util.List;

public class ApplyDiscount {

    private MenuOrders menuOrders;
    private AllDiscountCalculate allDiscountCalculate;
    private int applyDiscountPrice;

    public ApplyDiscount(String input, int visitDate, int totalPrice, List<MenuOrder> menuOrders) {
        initialized(input, visitDate, totalPrice, menuOrders);
        this.applyDiscountPrice = 0;
        addTotalPriceToAppliedDiscount();
        subtractDiscountFromAppliedDiscount();
    }

    private void initialized(String input, int visitDate, int totalPrice,
            List<MenuOrder> menuOrders) {
        this.menuOrders = new MenuOrders(input);
        this.allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice, menuOrders);
    }

    private void addTotalPriceToAppliedDiscount() {
        this.applyDiscountPrice += menuOrders.calculateTotalPrice();
    }

    private void subtractDiscountFromAppliedDiscount() {
        this.applyDiscountPrice -= allDiscountCalculate.getAllDiscountPrice();
    }

    public int getApplyDiscountPrice(){
        return applyDiscountPrice;
    }

}

