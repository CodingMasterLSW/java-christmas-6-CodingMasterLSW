package christmas.domain;

import java.util.List;

public class AllBenefit {

    private int totalBenefitsPrice;

    AllBenefit(VisitDate visitDate, int totalPrice, List<MenuOrder> orders) {
        this.totalBenefitsPrice = 0;
        calculateDiscounts(visitDate, totalPrice, orders);
        calculateGiftMenu(totalPrice);
    }

    private void calculateDiscounts(VisitDate visitDate, int totalPrice, List<MenuOrder> orders) {

        AllDiscountCalculate allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice,
                orders);
        this.totalBenefitsPrice += allDiscountCalculate.getAllDiscountPrice();

    }

    private void calculateGiftMenu(int totalPrice) {
        GiftMenu giftMenu = new GiftMenu(totalPrice);
        this.totalBenefitsPrice += giftMenu.getPrice();
    }

    public int getTotalBenefitsPrice(){
        return totalBenefitsPrice;
    }
}
