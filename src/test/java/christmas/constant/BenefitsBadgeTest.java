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
    void 뱃지_증정_테스트(int totalBenefitPrice, BenefitsBadge benefitsBadge) {
        assertThat(BenefitsBadge.getBadge(totalBenefitPrice)).isEqualTo(benefitsBadge);
    }

    private static Stream<Arguments> provideTestTotalBenefitPrice() {
        return Stream.of(
                Arguments.of(0, null),
                Arguments.of(5000, STAR),
                Arguments.of(9999, STAR),
                Arguments.of(10000,TREE),
                Arguments.of(19999,TREE),
                Arguments.of(20000,SANTA),
                Arguments.of(25000,SANTA)
        );
    }
}
