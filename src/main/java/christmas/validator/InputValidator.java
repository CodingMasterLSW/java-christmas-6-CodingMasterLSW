package christmas.validator;

import christmas.domain.MenuOrders;
import christmas.domain.VisitDate;
import christmas.view.InputView;

public class InputValidator {

    private InputView inputView;

    public InputValidator(InputView inputView) {
        this.inputView = inputView;
    }

    public int validateVisitDate() {
        while (true) {
            try {
                String input = inputView.readDate();
                VisitDate visitDate = new VisitDate(input);
                return visitDate.getVisitDate();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public MenuOrders validateMenuOrders(){
        while (true){
            try{
                String input = inputView.readMenuOrder();
                return new MenuOrders(input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
