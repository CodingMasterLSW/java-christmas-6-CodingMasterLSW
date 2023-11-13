package christmas.controller;

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
    }

    private void printMenuOrderSummary() {
        outputView.printMenuOrderMessage();
        printAllMenuOrders();
    }

    private void printAllMenuOrders() {
        for (MenuOrder order : menuOrders.getMenuOrders()) {
            outputView.printSingleMenuOrder(order.getMenu(), order.getQuantity());
        }
    }
}