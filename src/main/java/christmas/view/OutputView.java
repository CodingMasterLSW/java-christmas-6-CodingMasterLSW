package christmas.view;

import static christmas.constant.InputViewMessage.*;
import static christmas.constant.OutputViewMessage.*;


public class OutputView {

    public void printVisitDateWithNewLine(int visitDate) {
        printVisitDate(visitDate);
        printNewLine();
    }

    private void printVisitDate(int visitDate) {
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

    public void printBeforeDiscountPrice(int totalPrice) {
        beforeDiscountPriceMessage();
        displayTotalPrice(totalPrice);
    }

    private void beforeDiscountPriceMessage() {
        System.out.println(ORDER_PRICE_BEFORE_DISCOUNT);
    }

    private void displayTotalPrice(int totalPrice) {
        System.out.println(totalPrice);
    }

    public void printGiftMenuInformation(String giftName, int quantity) {
        giftMenuMessage();
        giftMenuInformation(giftName, quantity);
        printNewLine();
    }

    public void printNullGiftMenu(){
        giftMenuMessage();
        noExistGiftMenu();
        printNewLine();
    }

    private void giftMenuMessage() {
        System.out.println(GIFT_MENU_MESSAGE);
    }

    private void giftMenuInformation(String giftName, int quantity) {
        String message = String.format(PRINT_FORMAT, giftName, quantity);
        System.out.println(message);
    }

    private void noExistGiftMenu(){
        System.out.println(NO_EXIST);
    }

    public void printNewLine() {
        System.out.println();
    }


}
