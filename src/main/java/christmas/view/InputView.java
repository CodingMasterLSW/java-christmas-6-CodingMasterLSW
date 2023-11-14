package christmas.view;

import static christmas.constant.InputViewMessage.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.ViewValidator;

public class InputView {

    ViewValidator viewValidator = new ViewValidator();

    public String readDate() {
        printVisitDateMessage();
        String input = userInput();
        viewValidator.ensureValidDate(input);
        return input;
    }


    public String readMenuOrder() {
        printOrderMessage();
        String input = userInput();
        viewValidator.ensureValidMenuOrder(input);
        return input;
    }

    private String userInput() {
        return Console.readLine();
    }

    public void printStartMessage() {
        String message = String.format(START_MESSAGE, SETTING_MONTH);
        System.out.println(message);
    }

    private void printOrderMessage() {
        System.out.println(ORDER_MESSAGE);
    }

    private void printVisitDateMessage() {
        String message = String.format(VISIT_DATE_MESSAGE, SETTING_MONTH);
        System.out.println(message);
    }

}
