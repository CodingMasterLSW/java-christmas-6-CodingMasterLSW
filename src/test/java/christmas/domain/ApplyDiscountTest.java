package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplyDiscountTest {

    private MenuOrders menuOrders;

    @DisplayName("할인 적용 후 금액 계산")
    @Test
    void 할인_적용_후_금액(){
        String input = "티본스테이크-1,크리스마스파스타-1";
        int visitDate = 1;
        this.menuOrders = new MenuOrders(input);
        ApplyDiscount applyDiscount = new ApplyDiscount(visitDate, menuOrders);
        assertThat(applyDiscount.getApplyDiscountPrice()).isEqualTo(74954); // 총 주문금액 80000 - 할인합계 5046
    }


}
