package christmas.domain;


public class ApplyDiscount {

    private final MenuOrders menuOrders;
    private final AllDiscountCalculate allDiscountCalculate;
    private int applyDiscountPrice;

    public ApplyDiscount(int visitDate, MenuOrders menuOrders) {
        this.menuOrders = menuOrders;
        int totalPrice = menuOrders.calculateTotalPrice();
        this.allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice, menuOrders.getMenuOrders());
        this.applyDiscountPrice = calculateFinalPrice();
    }

    private int calculateFinalPrice() {
        int totalDiscount = allDiscountCalculate.getAllDiscountPrice();
        return menuOrders.calculateTotalPrice() - totalDiscount;
    }

    public int getApplyDiscountPrice() {
        return applyDiscountPrice;
    }
}

