package proj.discountCouponApp.coupon;

import proj.discountCouponApp.cart.Cart;
import proj.discountCouponApp.cart.CartItem;
import proj.discountCouponApp.strategy.DiscountStrategy;
import proj.discountCouponApp.strategy.DiscountStrategyManager;
import proj.discountCouponApp.strategy.StrategyType;

public class SeasonalOffer extends Coupon {

    private final double percent;
    private final String category;
    private final DiscountStrategy strategy;

    public SeasonalOffer(double percent, String category) {
        this.percent = percent;
        this.category = category;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT, percent, 0.0);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getCategory().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getDiscount(Cart cart) {
        double categoryTotal = 0.0;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getCategory().equalsIgnoreCase(category)) {
                categoryTotal += item.itemTotal();
            }
        }
        return strategy.calculate(categoryTotal);
    }

    @Override
    public String name() {
        return "Seasonal Offer " + (int) percent + "% off on " + category;
    }
}
