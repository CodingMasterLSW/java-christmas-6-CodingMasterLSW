package christmas.domain;

import christmas.utils.DomainValidator;
import christmas.utils.MenuOrderParser;
import java.util.List;

public class MenuOrders {

    private final List<MenuOrder> menuOrders;
    private final DomainValidator domainValidator = new DomainValidator();
    private final MenuOrderParser menuOrderParser = new MenuOrderParser();

    public MenuOrders(String input){
        this.menuOrders = menuOrderParser.parseOrders(input);
        domainValidator.validateMenuOrder(menuOrders);
    }


}
