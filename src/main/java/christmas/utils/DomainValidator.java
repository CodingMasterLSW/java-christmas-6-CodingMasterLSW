package christmas.utils;

import static christmas.constant.ValidateErrorMessage.INVALID_DATE;

public class DomainValidator {

    private final static int DATE_START_NUM = 1;
    private final static int DATE_END_NUM = 31;

    public void validateVisitDate(int visitDate) {
        checkNumbersRange(visitDate);
    }

    private void checkNumbersRange(int visitDate) {
        if (visitDate < DATE_START_NUM || visitDate > DATE_END_NUM) {
            throw new IllegalArgumentException(INVALID_DATE);
        }
    }


}
