package christmas.controller;

import christmas.domain.VisitDate;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private InputValidator inputValidator;
    private InputView inputView;
    private OutputView outputView;

    public OrderController() {
        this.inputView = new InputView();
        this.inputValidator = new InputValidator(inputView);
        this.outputView = new OutputView();

    }

    public void start() {
        inputView.printStartMessage();
        int visitDate = inputValidator.checkReadDate();
        inputValidator.checkReadMenuOrder();
        outputView.printVisitDateWithNewLine(visitDate);

    }

}
