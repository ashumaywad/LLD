package proj.discountCouponApp.coupon;

import proj.discountCouponApp.cart.Cart;

public abstract class Coupon {

    private Coupon next;

    public Coupon getNext() {
        return next;
    }

    public void setNext(Coupon next) {
        this.next = next;
    }

    public void applyDiscount(Cart cart) {
        if(isApplicable(cart)) {
            cart.applyDiscount(getDiscount(cart));
            if(!isCombinable()) return;
        }
        if(next != null) next.applyDiscount(cart);
    }

    public abstract boolean isApplicable(Cart cart);
    public abstract double getDiscount(Cart cart);
    public boolean isCombinable() {
        return true;
    }
    public abstract String name();
}
