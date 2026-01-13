package proj.discountCouponApp.strategy;

public class DiscountStrategyManager {

    private static DiscountStrategyManager instance;

    private DiscountStrategyManager() {}

    public static synchronized DiscountStrategyManager getInstance() {
        if(instance == null) {
            instance = new DiscountStrategyManager();
        }
        return instance;
    }

    public DiscountStrategy getStrategy(StrategyType type, double p1, double p2) {
        return switch (type) {
            case FLAT -> new FlatDiscountStrategy(p1);
            case PERCENT -> new PercentageDiscountStrategy(p1);
            case PERCENT_WITH_CAP -> new PercentageWithCapStrategy(p1, p2);
        };
    }
}
