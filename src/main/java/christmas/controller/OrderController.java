package christmas.controller;

import static christmas.constant.OutputViewMessage.*;

import christmas.domain.AllDiscountCalculate;
import christmas.domain.GiftMenu;
import christmas.domain.MenuOrder;
import christmas.domain.MenuOrders;
import christmas.domain.discount.ChristmasEvent;
import christmas.domain.discount.DateOfStarsEvent;
import christmas.domain.discount.DayOfWeekEvent;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private InputValidator inputValidator;
    private InputView inputView;
    private OutputView outputView;
    private MenuOrders menuOrders;
    private GiftMenu giftMenu;
    private AllDiscountCalculate allDiscountCalculate;

    public OrderController() {
        this.inputView = new InputView();
        this.inputValidator = new InputValidator(inputView);
        this.outputView = new OutputView();
    }

    public void start() {
        inputView.printStartMessage();
        int visitDate = inputValidator.checkReadDate();
        this.menuOrders = inputValidator.checkReadMenuOrder();
        outputView.printVisitDateWithNewLine(visitDate);

        printMenuOrderSummary();
        displayTotalPriceBeforeDiscount();

        this.giftMenu = new GiftMenu(menuOrders.calculateTotalPrice());
        printGiftMenu(giftMenu.getName(), giftMenu.getQuantity());

        int totalPrice = menuOrders.calculateTotalPrice();
        this.allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice,
                menuOrders.getMenuOrders());

        calculateAndPrintDiscounts();

    }

    private void printMenuOrderSummary() {
        outputView.printMenuOrderMessage();
        printAllMenuOrders();
        outputView.printNewLine();
    }

    private void displayTotalPriceBeforeDiscount() {
        int totalPrice = menuOrders.calculateTotalPrice();
        outputView.printBeforeDiscountPrice(totalPrice);
        outputView.printNewLine();
    }

    private void printAllMenuOrders() {
        for (MenuOrder order : menuOrders.getMenuOrders()) {
            outputView.printSingleMenuOrder(order.getMenu(), order.getQuantity());
        }
    }

    private void printGiftMenu(String giftName, int quantity) {
        if (giftName == null || giftName.isEmpty()) {
            outputView.printNullGiftMenu();
            return;
        }
        outputView.printGiftMenuInformation(giftName, quantity);
    }

    private void calculateAndPrintDiscounts() {
        outputView.benefitMessage();
        if (!checkDiscounts()) {
            outputView.printNoExist();
            return;
        }
        printDiscountDetails();

    }

    private boolean checkDiscounts() {
        return isDiscountAvailable(allDiscountCalculate.getChristmasDatePrice()) ||
                isDiscountAvailable(allDiscountCalculate.getDayOfWeekdayPrice()) ||
                isDiscountAvailable(allDiscountCalculate.getDayOfWeekdayPrice()) ||
                isDiscountAvailable(allDiscountCalculate.getSpecialPrice()) ||
                isDiscountAvailable(giftMenu.getPrice());
    }

    private boolean isDiscountAvailable(int discountAmount) {
        return discountAmount > 0;
    }

    private void printDiscountDetails() {
        printIfDiscountAvailable(CHRISTMAS_DATE_DISCOUNT,
                allDiscountCalculate.getChristmasDatePrice());
        printIfDiscountAvailable(WEEKDAY_DISCOUNT, allDiscountCalculate.getDayOfWeekdayPrice());
        printIfDiscountAvailable(WEEKEND_DISCOUNT, allDiscountCalculate.getDayOfWeekendPrice());
        printIfDiscountAvailable(SPECIAL_DISCOUNT, allDiscountCalculate.getSpecialPrice());
        printIfDiscountAvailable(GIFT_MENU_DISCOUNT, giftMenu.getPrice());
    }

    private void printIfDiscountAvailable(String discountName, int discountAmount) {
        if (isDiscountAvailable(discountAmount)) {
            outputView.printDiscountEvent(discountName, discountAmount);
        }

    }
}