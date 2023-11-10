package christmas.constant;

public enum StoreMenu {

    APPETIZER_MENU(new String[]{"양송이수프", "타파스", "시저샐러드"}, new int[]{6_000, 5_500, 8_000}),
    MAIN_MENU(new String[]{"티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"},
            new int[]{55_000, 54_000, 35_000, 25_000}),
    DESSERT_MENU(new String[]{"초코케이크", "아이스크림"}, new int[]{15_000, 5_000}),
    DRINK_MENU(new String[]{"제로콜라", "레드와인", "샴페인"}, new int[]{3_000, 60_000, 25_000});

    private final String[] storeMenus;
    private final int[] prices;

    StoreMenu(String[] storeMenus, int[] prices) {
        this.storeMenus = storeMenus;
        this.prices = prices;
    }


    public String[] getStoreMenus() {
        return storeMenus;
    }

    public int[] getPrices() {
        return prices;
    }

}
