package christmas.utils;

import static christmas.constant.ValidateErrorMessage.NOT_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.domain.MenuOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ViewValidatorTest {

    ViewValidator viewValidator = new ViewValidator();

    @DisplayName("메뉴형식이 예시와 다른 경우")
    @ValueSource(strings = {"파스타-1,양송이수프--1", "파스타-a", "파스타-1.양송이수프-1", "test", "1-파스타"})
    @ParameterizedTest
    void 예시와_다른_입력(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            viewValidator.ensureValidMenuOrder(input);
        });
    }

    @DisplayName("입력이 공백인 경우")
    @Test
    void 입력_공백() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "";
            viewValidator.ensureValidMenuOrder(input);
        });
        assertThat(exception.getMessage()).isEqualTo(NOT_NULL);
    }

    @DisplayName("주문한 메뉴가 1 미만인 경우")
    @ValueSource(strings = {"제로콜라-1,초코케이크-0","제로콜라-0,초코케이크-1","제로콜라--1,초코케이크-1"})
    @ParameterizedTest
    void 주문_메뉴_1_미만(String input){
        assertThrows(IllegalArgumentException.class, () ->{
            viewValidator.ensureValidMenuOrder(input);
        });
    }


}
