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

    public void printNewLine(){
        System.out.println();
    }

}
