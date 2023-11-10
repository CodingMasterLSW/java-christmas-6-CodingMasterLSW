package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.ViewValidator;

public class InputView {

    private final static String VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    ViewValidator viewValidator = new ViewValidator();

    public String readDate() {
        System.out.println(VISIT_DATE_MESSAGE);
        String input = Console.readLine();
        viewValidator.validateReadDate(input);
        return input;
    }


}
