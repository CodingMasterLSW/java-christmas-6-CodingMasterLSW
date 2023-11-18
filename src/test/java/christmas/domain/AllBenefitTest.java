package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllBenefitTest {

    private List<MenuOrder> menuOrders;

    @DisplayName("증정품이 있는 총혜택금액 계산")
    @Test
    void 증정품_존재하는_총_혜택금액_계산() {
        String input = "3";
        VisitDate visitDate = new VisitDate(input);
        int totalPrice = 186000;
        menuOrders = Arrays.asList(
                new MenuOrder("티본스테이크", 1),
                new MenuOrder("초코케이크", 1),
                new MenuOrder("제로콜라", 1),
                new MenuOrder("바비큐립", 2),
                new MenuOrder("아이스크림", 1)
        );
        AllBenefit allBenefit = new AllBenefit(visitDate, totalPrice, menuOrders);
        assertThat(allBenefit.getTotalBenefitsPrice()).isEqualTo(31246); //allDiscount 6246 +giftMenu 25000


    }

}
