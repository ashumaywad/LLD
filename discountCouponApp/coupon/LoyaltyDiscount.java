package proj.discountCouponApp.coupon;

import proj.discountCouponApp.cart.Cart;
import proj.discountCouponApp.strategy.DiscountStrategy;
import proj.discountCouponApp.strategy.DiscountStrategyManager;
import proj.discountCouponApp.strategy.StrategyType;

public class LoyaltyDiscount extends Coupon {

    private final double percent;
    private final DiscountStrategy strategy;

    public LoyaltyDiscount(double percent) {
        this.percent = percent;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT, percent, 0.0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return cart.isLoyaltyMember();
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getCurrentTotal());
    }

    @Override
    public String name() {
        return "Loyalty Discount " + (int) percent + "%";
    }
}

