package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplyDiscountTest {

    private List<MenuOrder> menuOrders;

    @DisplayName("할인 적용 후 금액 계산")
    @Test
    void 할인_적용_후_금액(){
        String input = "티본스테이크-1,크리스마스파스타-1";
        int visitDate = 1;
        int totalPrice = 80000;
        menuOrders = Arrays.asList(
                new MenuOrder("티본스테이크",1),
                new MenuOrder("크리스마스파스타",1)
        );

        ApplyDiscount applyDiscount = new ApplyDiscount(input, visitDate, totalPrice, menuOrders);

        assertThat(applyDiscount.getApplyDiscountPrice()).isEqualTo(74954); // 총 주문금액 80000 - 할인합계 5046
    }


}
