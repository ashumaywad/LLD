package proj.discountCouponApp.coupon;

import proj.discountCouponApp.cart.Cart;
import proj.discountCouponApp.strategy.DiscountStrategy;
import proj.discountCouponApp.strategy.DiscountStrategyManager;
import proj.discountCouponApp.strategy.StrategyType;

public class BulkPurchaseDiscount extends Coupon {

    private final double threshold;
    private final double flatOff;
    private final DiscountStrategy strategy;

    public BulkPurchaseDiscount(double threshold, double flatOff) {
        this.threshold = threshold;
        this.flatOff = flatOff;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.FLAT, flatOff, 0.0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.getOriginalTotal() >= threshold;
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getCurrentTotal());
    }

    @Override
    public String name() {
        return "Bulk Purchase Rs " + (int) flatOff + " off (Min " + (int) threshold + ")";
    }
}
