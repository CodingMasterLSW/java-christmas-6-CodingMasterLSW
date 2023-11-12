package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChristmasDiscountTest {



    @DisplayName("크리스마스 할인 테스트")
    @ParameterizedTest
    @MethodSource("provideDatesAndExpectedDiscounts")
    void 하루_지날수록_100원씩_증가(int visitDate, int expectedDiscount) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(visitDate);
        int christmasDiscountPrice = christmasDiscount.getChristmasDiscountPrice();
        assertThat(christmasDiscountPrice).isEqualTo(expectedDiscount);
    }

    private static Stream<Arguments> provideDatesAndExpectedDiscounts() {
        return Stream.of(
                Arguments.of(1, 1000),
                Arguments.of(24, 3300),
                Arguments.of(25, 3400),
                Arguments.of(26, 0),
                Arguments.of(31, 0)
        );
    }


}
