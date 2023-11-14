package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuOrder;
import christmas.domain.VisitDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DayOfWeekEventTest {

    private List<MenuOrder> menuOrders;

    @BeforeEach
    void setup() {
        menuOrders = Arrays.asList(
                new MenuOrder("티본스테이크", 2),
                new MenuOrder("초코케이크", 1),
                new MenuOrder("제로콜라", 1),
                new MenuOrder("바비큐립", 4),
                new MenuOrder("아이스크림", 2)
        );
    }

    @DisplayName("주말 할인 테스트")
    @ValueSource(strings = {"1","2","8","9","15","16"})
    @ParameterizedTest
    void 주말_할인_테스트(VisitDate visitDate) {

        DayOfWeekEvent dayOfWeekEvent = new DayOfWeekEvent(visitDate, menuOrders);
        assertThat(dayOfWeekEvent.getWeekendDiscount()).isEqualTo(12138); // (티본스테이크2, 바비큐립4) * 2023
        assertThat(dayOfWeekEvent.getWeekDayDiscount()).isEqualTo(0);
    }

    @DisplayName("평일 할인 테스트")
    @ValueSource(strings = {"3","4","5","6","7","28","31"})
    @ParameterizedTest
    void 평일_할인_테스트(VisitDate visitDate){
        DayOfWeekEvent dayOfWeekEvent = new DayOfWeekEvent(visitDate, menuOrders);
        assertThat(dayOfWeekEvent.getWeekDayDiscount()).isEqualTo(6069); // (초코케이크1, 아이스크림2) * 2023
        assertThat(dayOfWeekEvent.getWeekendDiscount()).isEqualTo(0);
    }

}
