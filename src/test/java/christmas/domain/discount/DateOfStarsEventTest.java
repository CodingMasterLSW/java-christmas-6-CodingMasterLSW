package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DateOfStarsEventTest {

    @DisplayName("별표가 있는 날짜에 추가 할인 테스트")
    @ParameterizedTest
    @MethodSource("provideDateAndCalculateDiscount")

    void 별표_있는날에는_추가할인(VisitDate visitDate, int expectedDiscount) {
        DateOfStarsEvent dateOfStarsEvent = new DateOfStarsEvent(visitDate);
        int totalDiscount = dateOfStarsEvent.getTotalDiscount();
        assertThat(totalDiscount).isEqualTo(expectedDiscount);
    }

    private static Stream<Arguments> provideDateAndCalculateDiscount() {
        return Stream.of(
                Arguments.of(new VisitDate("3"), 1000),
                Arguments.of(new VisitDate("10"), 1000),
                Arguments.of(new VisitDate("17"), 1000),
                Arguments.of(new VisitDate("24"), 1000),
                Arguments.of(new VisitDate("25"), 1000),
                Arguments.of(new VisitDate("31"), 1000),
                Arguments.of(new VisitDate("1"), 0),
                Arguments.of(new VisitDate("2"), 0)
        );
    }

}
