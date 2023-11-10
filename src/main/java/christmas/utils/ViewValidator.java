package christmas.utils;

import static christmas.constant.ValidateErrorMessage.INVALID_DATE;

public class ViewValidator {

    public void validateReadDate(String input) {
        checkInputIsNotNull(input);
        checkOnlyNumber(input);
    }

    private void checkInputIsNotNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

    private void checkOnlyNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }

}
