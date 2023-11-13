package christmas.view;

import static christmas.constant.InputViewMessage.*;
import static christmas.constant.OutputViewMessage.*;

public class OutputView {

    public void printVisitDateWithNewLine(int visitDate){
        printVisitDate(visitDate);
        printNewLine();
    }

    private void printVisitDate(int visitDate) {
        String message = String.format(VISIT_DATE_MESSAGE_OUTPUT, SETTING_MONTH, visitDate);
        System.out.println(message);
    }

    public void printMenuOrderMessage(){
        System.out.println(MENU_ORDER_OUTPUT);

    }

    public void printSingleMenuOrder(String menuName, int quantity){
        String formattedOrder = String.format(ORDER_FORMAT, menuName, quantity);
        System.out.println(formattedOrder);
    }

    public void printNewLine(){
        System.out.println();
    }

}
