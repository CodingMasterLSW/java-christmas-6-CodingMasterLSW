package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChristmasEventTest {

    @DisplayName("크리스마스 할인 테스트")
    @ParameterizedTest
    @MethodSource("provideDatesAndExpectedDiscounts")
    void 하루_지날수록_100원씩_증가(VisitDate visitDate, int expectedDiscount) {
        ChristmasEvent christmasEvent = new ChristmasEvent(visitDate);
        int christmasDiscountPrice = christmasEvent.getChristmasDiscountPrice();
        assertThat(christmasDiscountPrice).isEqualTo(expectedDiscount);
    }

    private static Stream<Arguments> provideDatesAndExpectedDiscounts() {
        return Stream.of(
                Arguments.of(new VisitDate("1"), 1000),
                Arguments.of(new VisitDate("24"), 3300),
                Arguments.of(new VisitDate("25"), 3400),
                Arguments.of(new VisitDate("26"), 0),
                Arguments.of(new VisitDate("31"), 0)
        );
    }

}
