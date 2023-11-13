package christmas.view;

import static christmas.constant.InputViewMessage.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.ViewValidator;

public class InputView {

    ViewValidator viewValidator = new ViewValidator();

    public String readDate() {
        System.out.println(VISIT_DATE_MESSAGE);
        String input = userInput();
        viewValidator.validateReadDate(input);
        return input;
    }

    public void startMessage(){
        System.out.println(START_MESSAGE);
    }

    public String readMenuOrder(){
        System.out.println(ORDER_MESSAGE);
        String input = userInput();
        viewValidator.validateReadMenuOrder(input);
        return input;
    }


    private String userInput(){
        return Console.readLine();
    }




}
