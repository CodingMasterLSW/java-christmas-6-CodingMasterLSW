package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.discount.ChristmasEvent;
import christmas.domain.discount.DateOfStarsEvent;
import christmas.domain.discount.DayOfWeekEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class AllDiscountCalculateTest {

    private List<MenuOrder> menuOrders;

    @DisplayName("총 할인금액 테스트")
    @ParameterizedTest
    @MethodSource("provideDatesAndExpectedDiscounts")
    void 총_할인율_테스트(int visitDate, int totalPrice, int expectedDiscount) {
        menuOrders = Arrays.asList(
                new MenuOrder("티본스테이크", 1),
                new MenuOrder("초코케이크", 1),
                new MenuOrder("제로콜라", 1),
                new MenuOrder("바비큐립", 2),
                new MenuOrder("아이스크림", 1)
        );
        ChristmasEvent christmasEvent = new ChristmasEvent(visitDate);
        DayOfWeekEvent dayOfWeekEvent = new DayOfWeekEvent(visitDate, menuOrders);
        DateOfStarsEvent dateOfStarsEvent = new DateOfStarsEvent(visitDate);
        AllDiscountCalculate allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice,
                menuOrders);
        assertThat(allDiscountCalculate.getAllDiscountPrice()).isEqualTo(expectedDiscount);
    }

    private static Stream<Arguments> provideDatesAndExpectedDiscounts() {
        return Stream.of(
                Arguments.of(1, 186000, 7069), // christmasEvent 1000, dayOfWeekEvent 6069
                Arguments.of(3, 186000, 6246),
                // christmasEvent 1200, dayOfWeekEvent 4046, dateOfStarsEvent 1000
                Arguments.of(12, 186000, 6146), // christmasEvent 2100, dayOfWeekEvent 4046
                Arguments.of(16, 186000, 8569), // christmasEvent 2500, dayOfWeekEvent 6069
                Arguments.of(25, 186000, 8446),
                // christmasEvent 3400, dayOfWeekEvent 4046, dateOfStartsEvent 1000
                Arguments.of(26, 186000, 4046), // dayOfWeekEvent 4046
                Arguments.of(29, 186000, 6069), // dayOfWeekEvent 6069
                Arguments.of(31, 186000, 5046) // dayOfWeekEvent 4046, dateOfStartsEvent 1000
        );
    }

    @DisplayName("총 주문금액이 10000 미만이면 할인을 받지 못 함")
    @ParameterizedTest
    @MethodSource("provideUnderMinimumDiscount")
    void 할인_못_받는_경우_테스트(int visitDate, int totalPrice, int expectedDiscount) {

        menuOrders = Arrays.asList(
                new MenuOrder("제로콜라", 1),
                new MenuOrder("양송이스푸", 1)
        );
        ChristmasEvent christmasEvent = new ChristmasEvent(visitDate);
        DayOfWeekEvent dayOfWeekEvent = new DayOfWeekEvent(visitDate, menuOrders);
        DateOfStarsEvent dateOfStarsEvent = new DateOfStarsEvent(visitDate);
        AllDiscountCalculate allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice,
                menuOrders);
        assertThat(allDiscountCalculate.getAllDiscountPrice()).isEqualTo(expectedDiscount);
    }

    private static Stream<Arguments> provideUnderMinimumDiscount() {
        return Stream.of(
                Arguments.of(1, 9000, 0),
                Arguments.of(3, 9000, 0),
                Arguments.of(13, 9000, 0),
                Arguments.of(25, 9000, 0),
                Arguments.of(30, 9000, 0)
        );

    }

}