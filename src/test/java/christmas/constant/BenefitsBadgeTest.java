package christmas.constant;

import static christmas.constant.BenefitsBadge.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BenefitsBadgeTest {

    @DisplayName("혜택금액에 따른 뱃지 증정")
    @MethodSource("provideTestTotalBenefitPrice")
    @ParameterizedTest
    void 뱃지_증정_테스트(int totalBenefitPrice, String benefitsBadge) {
        assertThat(BenefitsBadge.getBadge(totalBenefitPrice)).isEqualTo(benefitsBadge);
    }

    private static Stream<Arguments> provideTestTotalBenefitPrice() {
        return Stream.of(
                Arguments.of(0, null),
                Arguments.of(5000, "별"),
                Arguments.of(9999, "별"),
                Arguments.of(10000, "트리"),
                Arguments.of(19999, "트리"),
                Arguments.of(20000, "산타"),
                Arguments.of(25000, "산타")
        );
    }
}
