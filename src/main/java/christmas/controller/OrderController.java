package christmas.controller;

import static christmas.constant.OutputViewMessage.*;

import christmas.constant.BenefitsBadge;
import christmas.domain.AllDiscountCalculate;
import christmas.domain.ApplyDiscount;
import christmas.domain.GiftMenu;
import christmas.domain.MenuOrder;
import christmas.domain.MenuOrders;
import christmas.domain.VisitDate;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private VisitDate visitDate;
    private InputValidator inputValidator;
    private InputView inputView;
    private OutputView outputView;
    private MenuOrders menuOrders;
    private GiftMenu giftMenu;
    private AllDiscountCalculate allDiscountCalculate;
    private ApplyDiscount applyDiscount;

    public OrderController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator(inputView);

    }

    public void start() {
        inputView.printStartMessage();
        processInput();
        printMenuOrderSummary();
        displayTotalPriceBeforeDiscount();
        processGiftMenu();
        processDiscountCalculation();
        calculateAndPrintDiscounts();
        calculateAndPrintAllBenefitsPrice();
        applyDiscountAndPrint();
        printBadge();
    }

    private void processInput() {
        this.visitDate = inputValidator.validateVisitDate();
        this.menuOrders = inputValidator.validateMenuOrders();
        outputView.printVisitDateWithMonth(visitDate);
    }

    private void printMenuOrderSummary() {
        outputView.printMenuOrderMessage();
        printAllMenuOrders();
        outputView.printNewLine();
    }

    private void displayTotalPriceBeforeDiscount() {
        int totalPrice = menuOrders.calculateTotalPrice();
        outputView.printOrderPriceBeforeDiscount(totalPrice);
        outputView.printNewLine();
    }

    private void processGiftMenu() {
        this.giftMenu = new GiftMenu(menuOrders.calculateTotalPrice());
        printGiftMenu(giftMenu.getName(), giftMenu.getQuantity());
    }

    private void processDiscountCalculation() {
        int totalPrice = menuOrders.calculateTotalPrice();
        this.allDiscountCalculate = new AllDiscountCalculate(visitDate, totalPrice,
                menuOrders.getMenuOrders());
    }


    private void calculateAndPrintAllBenefitsPrice() {
        int allBenefitsPrice = calculateAllBenefitsPrice();
        outputView.printTotalBenefitPrice(allBenefitsPrice);
    }

    private void applyDiscountAndPrint() {
        this.applyDiscount = new ApplyDiscount(visitDate, menuOrders);
        outputView.printAppliedDiscountPriceMessage(applyDiscount.getApplyDiscountPrice());
    }

    private void printBadge() {
        String badge = BenefitsBadge.getBadge(
                allDiscountCalculate.getAllDiscountPrice() + giftMenu.getPrice());
        outputView.printBadgeMessage(badge);
    }

    private void printAllMenuOrders() {
        for (MenuOrder order : menuOrders.getMenuOrders()) {
            outputView.printSingleMenuOrder(order.getMenu(), order.getQuantity());
        }
    }

    private void printGiftMenu(String giftName, int quantity) {
        if (giftName == null || giftName.isEmpty()) {
            outputView.printNoGiftMenu();
            return;
        }
        outputView.printGiftMenuDetails(giftName, quantity);
    }

    private void calculateAndPrintDiscounts() {
        outputView.benefitMessage();
        if (!checkDiscounts()) {
            outputView.printNoExist();
            outputView.printNewLine();
            return;
        }
        printDiscountDetails();
        outputView.printNewLine();

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

    private int calculateAllBenefitsPrice() {
        return allDiscountCalculate.getAllDiscountPrice() + giftMenu.getPrice();
    }

}