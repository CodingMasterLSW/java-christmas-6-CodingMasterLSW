package christmas.validator;

import christmas.view.InputView;

public class InputValidator {

    private InputView inputView;

    public InputValidator(InputView inputView) {
        this.inputView = inputView;
    }

    public String checkReadDate() {
        while (true) {
            try {
                String input = inputView.readDate();
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public String checkReadMenuOrder(){
        while (true){
            try{
                String input = inputView.readMenuOrder();
                return input;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}