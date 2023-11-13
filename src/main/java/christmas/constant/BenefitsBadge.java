package christmas.constant;

public enum BenefitsBadge {

    STAR(5000,9999),
    TREE(10000,19999),
    SANTA(20000, Integer.MAX_VALUE);

    private final int minBenefit;
    private final int maxBenefit;

    BenefitsBadge(int minBenefit, int maxBenefit){
        this.minBenefit = minBenefit;
        this.maxBenefit = maxBenefit;
    }

    public static BenefitsBadge getBadge(int totalBenefitPrice){
        for(BenefitsBadge benefitsBadge : BenefitsBadge.values()){
            if (totalBenefitPrice>=benefitsBadge.minBenefit && totalBenefitPrice<=benefitsBadge.maxBenefit){
                return benefitsBadge;
            }
        }
        return null;
    }


}
