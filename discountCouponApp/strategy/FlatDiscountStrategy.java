package proj.discountCouponApp.strategy;

public class FlatDiscountStrategy implements DiscountStrategy{

    private final double amount;

    public FlatDiscountStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculate(double baseAmount) {
        return Math.min(amount, baseAmount);
    }
}
