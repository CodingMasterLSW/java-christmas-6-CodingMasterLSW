package christmas.domain;

import christmas.utils.DomainValidator;
import christmas.utils.MenuOrderParser;
import java.util.List;

public class MenuOrders {

    private final List<MenuOrder> menuOrders;
    private final DomainValidator domainValidator = new DomainValidator();
    private final MenuOrderParser menuOrderParser = new MenuOrderParser();

    public MenuOrders(String input) {
        this.menuOrders = menuOrderParser.parseOrders(input);
        domainValidator.ensureValidMenuOrders(menuOrders);
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (MenuOrder order : menuOrders) {
            totalPrice += order.calculatePrice();
        }
        return totalPrice;
    }

    public List<MenuOrder> getMenuOrders(){
        return menuOrders;
    }

}
