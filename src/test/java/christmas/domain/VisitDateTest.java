package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.utils.ViewValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VisitDateTest {
    ViewValidator viewValidator = new ViewValidator();

    @DisplayName("1~31 범위가 아닐경우 예외 발생")
    @ValueSource(strings = {"0", "-1", "32", "100"})
    @ParameterizedTest
    void 올바른_범위가_아닌_경우(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new VisitDate(input);
        });
    }

    @DisplayName("공백을 입력한 경우 예외 발생")
    @Test
    void 입력이_null_인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "";
            viewValidator.validateReadDate(input);
        });
    }

    @DisplayName("입력값이 숫자가 아닐 경우 예외 발생")
    @ValueSource(strings = {"a","a123","0a"})
    @ParameterizedTest
    void 입력값이_숫자가_아닐경우(String input){
        assertThrows(IllegalArgumentException.class, () -> {
            viewValidator.validateReadDate(input);
        });
    }

}
