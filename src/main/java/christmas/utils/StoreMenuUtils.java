package christmas.utils;

import christmas.constant.StoreMenu;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StoreMenuUtils {

    public static List<String> getAllMenus() {
        return Arrays.stream(StoreMenu.values())
                .flatMap(enumItem -> Arrays.stream(enumItem.getStoreMenus()))
                .collect(Collectors.toList());
    }

}
