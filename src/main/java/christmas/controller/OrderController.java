package christmas.controller;

import christmas.domain.VisitDate;
import christmas.validator.InputValidator;
import christmas.view.InputView;

public class OrderController {

    private InputValidator inputValidator;
    private InputView inputView;

    public OrderController() {
        this.inputView = new InputView();
        this.inputValidator = new InputValidator(inputView);

    }

    public void start() {
        inputView.printStartMessage();
        inputValidator.checkReadDate();
        inputValidator.checkReadMenuOrder();
    }

}
