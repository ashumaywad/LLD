package proj.discountCouponApp.strategy;

public class PercentageWithCapStrategy implements DiscountStrategy{

    private final double percent;
    private final double cap;

    public PercentageWithCapStrategy(double percent, double cap) {
        this.percent = percent;
        this.cap = cap;
    }

    @Override
    public double calculate(double baseAmount) {
        return Math.min((percent * 100.0) * baseAmount, cap);
    }
}
