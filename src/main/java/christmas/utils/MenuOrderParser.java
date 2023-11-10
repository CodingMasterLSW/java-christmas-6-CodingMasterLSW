package christmas.utils;

import christmas.domain.MenuOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuOrderParser {

    public List<MenuOrder> parseOrders(String input) {
        return Arrays.stream(input.split(","))
                .map(item -> item.split("-"))
                .map(parts -> new MenuOrder(parts[0], Integer.parseInt(parts[1])))
                .collect(Collectors.toList());
    }


}
