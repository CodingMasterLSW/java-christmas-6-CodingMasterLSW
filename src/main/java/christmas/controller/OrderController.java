package christmas.controller;

import christmas.domain.GiftMenu;
import christmas.domain.MenuOrder;
import christmas.domain.MenuOrders;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private InputValidator inputValidator;
    private InputView inputView;
    private OutputView outputView;
    private MenuOrders menuOrders;
    private GiftMenu giftMenu;

    public OrderController() {
        this.inputView = new InputView();
        this.inputValidator = new InputValidator(inputView);
        this.outputView = new OutputView();
    }

    public void start() {
        inputView.printStartMessage();
        int visitDate = inputValidator.checkReadDate();
        this.menuOrders = inputValidator.checkReadMenuOrder();
        outputView.printVisitDateWithNewLine(visitDate);

        printMenuOrderSummary();
        displayTotalPriceBeforeDiscount();

        this.giftMenu = new GiftMenu(menuOrders.calculateTotalPrice());
        printGiftMenu(giftMenu.getName(), giftMenu.getQuantity());

    }

    private void printMenuOrderSummary() {
        outputView.printMenuOrderMessage();
        printAllMenuOrders();
        outputView.printNewLine();
    }

    private void displayTotalPriceBeforeDiscount() {
        int totalPrice = menuOrders.calculateTotalPrice();
        outputView.printBeforeDiscountPrice(totalPrice);
        outputView.printNewLine();
    }

    private void printAllMenuOrders() {
        for (MenuOrder order : menuOrders.getMenuOrders()) {
            outputView.printSingleMenuOrder(order.getMenu(), order.getQuantity());
        }
    }

    private void printGiftMenu(String giftName, int quantity) {
        if (giftName == null || giftName.isEmpty()) {
            outputView.printNullGiftMenu();
            return;
        }
        outputView.printGiftMenuInformation(giftName, quantity);
    }

}