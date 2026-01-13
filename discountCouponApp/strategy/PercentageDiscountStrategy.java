package proj.discountCouponApp.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy{

    private final double percent;

    public PercentageDiscountStrategy(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculate(double baseAmount) {
        return (percent / 100.0) * baseAmount;
    }
}
