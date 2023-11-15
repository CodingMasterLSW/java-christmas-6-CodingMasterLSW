package christmas.utils;

import static christmas.constant.ValidateErrorMessage.INVALID_DATE;
import static christmas.constant.ValidateErrorMessage.INVALID_ORDER;
import static christmas.constant.ValidateErrorMessage.NOT_NULL;

import java.util.Arrays;

public class ViewValidator {

    private static final int VALIDATE_PART_LENGTH = 2;

    public void ensureValidDate(final String input) {
        validateNotNullOrEmpty(input, NOT_NULL);
        validateContainsOnlyDigits(input, INVALID_DATE);
    }

    public void ensureValidMenuOrder(final String input) {
        validateNotNullOrEmpty(input, NOT_NULL);
        validateMenuOrderFormat(input);
    }

    private void validateNotNullOrEmpty(String input, String errorMessage) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateContainsOnlyDigits(String input, String errorMessage) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateMenuOrderFormat(String input) {
        boolean isValidator = Arrays.stream(input.split(","))
                .allMatch(this::isValidMenuItemFormat);

        if (!isValidator) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    private boolean isValidMenuItemFormat(final String inputOrder) {
        String[] parts = inputOrder.split("-");
        return parts.length == VALIDATE_PART_LENGTH && isValidQuantity(parts[1]);
    }

    private boolean isValidQuantity(String OrderQuantity) {
        validateContainsOnlyDigits(OrderQuantity, INVALID_ORDER);
        int quantity = Integer.parseInt(OrderQuantity);
        return quantity > 0;
    }

}
