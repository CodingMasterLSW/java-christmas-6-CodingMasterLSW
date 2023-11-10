package christmas.utils;

import static christmas.constant.ValidateErrorMessage.INVALID_DATE;
import static christmas.constant.ValidateErrorMessage.INVALID_ORDER;

import java.util.Arrays;


public class ViewValidator {

    public void validateReadDate(String input) {
        checkInputIsNotNull(input, INVALID_DATE);
        checkOnlyNumber(input, INVALID_DATE);
    }

    public void validateReadMenuOrder(String input) {
        checkInputIsNotNull(input, INVALID_ORDER);
        validateSplitMenuItems(input);
    }

    private void checkInputIsNotNull(String input, String errorMessage) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void checkOnlyNumber(String input, String errorMessage) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateSplitMenuItems(String input) {
        boolean isValidator = Arrays.stream(input.split(","))
                .allMatch(this::validateFormMenuItem);

        if (!isValidator) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }


    private boolean validateFormMenuItem(String inputOrder) {
        String[] parts = inputOrder.split("-");
        return parts.length == 2 && isQuantityValid(parts[1]);
    }


    private boolean isQuantityValid(String OrderQuantity) {
        checkOnlyNumber(OrderQuantity, INVALID_ORDER);
        int quantity = Integer.parseInt(OrderQuantity);
        return quantity > 0;
    }


}
