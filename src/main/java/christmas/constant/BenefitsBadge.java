package christmas.constant;

public enum BenefitsBadge {

    STAR(5000, 9999, "별"),
    TREE(10000, 19999, "트리"),
    SANTA(20000, Integer.MAX_VALUE, "산타");

    private final int minBenefit;
    private final int maxBenefit;
    private final String description;

    BenefitsBadge(int minBenefit, int maxBenefit, String description) {
        this.minBenefit = minBenefit;
        this.maxBenefit = maxBenefit;
        this.description = description;
    }

    public static String getBadge(int totalBenefitPrice) {
        for (BenefitsBadge benefitsBadge : BenefitsBadge.values()) {
            if (totalBenefitPrice >= benefitsBadge.minBenefit
                    && totalBenefitPrice <= benefitsBadge.maxBenefit) {
                return benefitsBadge.description;
            }
        }
        return null;
    }
}
