package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GiftMenuTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("구매 금액에 따른 증정 이벤트 테스트")
    void 증정_이벤트_테스트(int testTotalPrice, String expectedName, int expectedPrice, int expectedQuantity) {
        GiftMenu giftMenu = new GiftMenu(testTotalPrice);
        assertThat(giftMenu.getName()).isEqualTo(expectedName);
        assertThat(giftMenu.getPrice()).isEqualTo(expectedPrice);
        assertThat(giftMenu.getQuantity()).isEqualTo(expectedQuantity);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(130000, "샴페인", 25000, 1),
                Arguments.of(110000, null, 0, 0),
                Arguments.of(120000, "샴페인", 25000, 1)
        );
    }
}
