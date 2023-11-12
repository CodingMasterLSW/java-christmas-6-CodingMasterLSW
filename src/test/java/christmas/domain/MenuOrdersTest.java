package christmas.domain;

import static christmas.constant.ValidateErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MenuOrdersTest {


    @DisplayName("중복메뉴를 입력한 경우")
    @Test
    void 중복_메뉴_입력() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "제로콜라-1,초코케이크-1,양송이수프-2,제로콜라-3";
            new MenuOrders(input);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_ORDER);

    }

    @DisplayName("메뉴판에 없는 메뉴를 입력한 경우")
    @Test
    void 존재하지_않는_메뉴_입력() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "제로콜라-1,초코케이크-1,양송이수프-2,치킨-1";
            new MenuOrders(input);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_ORDER);
    }

    @DisplayName("음료수만 주문한 경우")
    @Test
    void 음료수만_주문() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "제로콜라-1,레드와인-3,샴페인-5";
            new MenuOrders(input);
        });
        assertThat(exception.getMessage()).isEqualTo(NOT_ONLY_DRINKS);
    }

    @DisplayName("주문 총합이 20을 초과한 경우")
    @ValueSource(strings = {"타파스-5,양송이수프-5,바비큐립-10,초코케이크-1", "타파스-5,양송이수프-5,바비큐립-10,초코케이크-2"})
    @ParameterizedTest
    void 최대_주문_개수_초과(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new MenuOrders(input);
        });
    }

    @DisplayName("주문 총합 20 경곗값 테스트")
    @Test
    void 주문_총합_경곗값_테스트() {
        assertDoesNotThrow(() -> {
            String input = "타파스-5,양송이수프-5,바비큐립-10";
            new MenuOrders(input);
        });
    }

    @DisplayName("총 주문 금액 테스트")
    @Test

    void 주문_금액_테스트(){
        String input = "제로콜라-1,초코케이크-1,양송이수프-2";
        MenuOrders menuOrders = new MenuOrders(input);

        int totalPrice = menuOrders.calculateTotalPrice();
        assertThat(totalPrice).isEqualTo(30000);
    }

}
