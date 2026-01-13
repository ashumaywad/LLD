package proj.discountCouponApp.coupon;

import proj.discountCouponApp.cart.Cart;
import proj.discountCouponApp.strategy.DiscountStrategy;
import proj.discountCouponApp.strategy.DiscountStrategyManager;
import proj.discountCouponApp.strategy.StrategyType;

public class BankingCoupon extends Coupon {

    private final String bank;
    private final double minSpend;
    private final double percent;
    private final double cap;
    private final DiscountStrategy strategy;

    public BankingCoupon(String bank, double minSpend, double percent, double cap) {
        this.bank = bank;
        this.minSpend = minSpend;
        this.percent = percent;
        this.cap = cap;
        this.strategy = DiscountStrategyManager.getInstance()
                .getStrategy(StrategyType.PERCENT_WITH_CAP, percent, cap);
    }

    @Override
    public boolean isApplicable(Cart cart) {
        return bank.equalsIgnoreCase(cart.getPaymentBank())
                && cart.getOriginalTotal() >= minSpend;
    }

    @Override
    public double getDiscount(Cart cart) {
        return strategy.calculate(cart.getCurrentTotal());
    }

    @Override
    public String name() {
        return bank + " Bank Offer " + (int) percent + "% off upto Rs " + (int) cap;
    }
}
