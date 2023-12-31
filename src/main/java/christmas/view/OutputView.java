package christmas.view;

import static christmas.constant.InputViewMessage.*;
import static christmas.constant.OutputViewMessage.*;

import christmas.domain.VisitDate;

public class OutputView {

    public void printVisitDateWithMonth(VisitDate visitDate) {
        printVisitDate(visitDate);
        printNewLine();
    }

    private void printVisitDate(VisitDate visitDate) {
        String message = String.format(VISIT_DATE_MESSAGE_OUTPUT, SETTING_MONTH, visitDate);
        System.out.println(message);
    }

    public void printMenuOrderMessage() {
        System.out.println(MENU_ORDER_OUTPUT);

    }

    public void printSingleMenuOrder(String menuName, int quantity) {
        String formattedOrder = String.format(PRINT_FORMAT, menuName, quantity);
        System.out.println(formattedOrder);
    }

    public void printOrderPriceBeforeDiscount(int totalPrice) {
        beforeDiscountPriceMessage();
        displayTotalPrice(totalPrice);
    }

    private void beforeDiscountPriceMessage() {
        System.out.println(ORDER_PRICE_BEFORE_DISCOUNT);
    }

    private void displayTotalPrice(int totalPrice) {
        System.out.println(totalPrice);
    }

    public void printGiftMenuDetails(String giftName, int quantity) {
        giftMenuMessage();
        giftMenuInformation(giftName, quantity);
        printNewLine();
    }

    public void printNoGiftMenu() {
        giftMenuMessage();
        printNoExist();
        printNewLine();
    }

    private void giftMenuMessage() {
        System.out.println(GIFT_MENU_MESSAGE);
    }

    private void giftMenuInformation(String giftName, int quantity) {
        String message = String.format(PRINT_FORMAT, giftName, quantity);
        System.out.println(message);
    }

    public void printNoExist() {
        System.out.println(NO_EXIST);
    }

    public void benefitMessage() {
        System.out.println(APPLY_BENEFIT_OUTPUT);
    }


    public void printNewLine() {
        System.out.println();
    }

    public void printDiscountEvent(String eventName, int discountAmount) {
        if (discountAmount > 0) {
            String message = String.format(DISCOUNT_FORMAT, eventName, discountAmount);
            System.out.println(message);
        }
    }

    public void printTotalBenefitPrice(int allBenefitPrice) {
        allBenefitPriceMessage();
        calculateAllBenefitPrice(allBenefitPrice);
        printNewLine();

    }

    private void allBenefitPriceMessage() {
        System.out.println(ALL_BENEFIT_PRICE);
    }

    private void calculateAllBenefitPrice(int allBenefitPrice) {
        if (allBenefitPrice != 0) {
            String message = String.format(ALL_BENEFIT_PRICE_FORMAT, allBenefitPrice);
            System.out.println(message);
            return;
        }
        System.out.println(ALL_BENEFIT_PRICE_ZERO);
    }

    public void printAppliedDiscountPriceMessage(int applyDiscount) {
        afterPaymentMessage();
        printAfterPaymentMessage(applyDiscount);
        printNewLine();
    }

    private void printAfterPaymentMessage(int applyDiscount) {
        String message = String.format(AFTER_DISCOUNT_PAYMENT_PRICE_FORMAT, applyDiscount);
        System.out.println(message);
    }

    private void afterPaymentMessage() {
        System.out.println(AFTER_DISCOUNT_PAYMENT_PRICE);
    }

    public void printBadgeMessage(String benefitsBadge) {
        badgeMessage();
        getBadgeMessage(benefitsBadge);
        printNewLine();
    }

    private void getBadgeMessage(String benefitsBadge) {
        if (benefitsBadge == null) {
            System.out.println(NO_EXIST);
            return;
        }
        System.out.println(benefitsBadge);
    }

    private void badgeMessage() {
        String message = String.format(EVENT_BADGE_MESSAGE, SETTING_MONTH);
        System.out.println(message);
    }


}
