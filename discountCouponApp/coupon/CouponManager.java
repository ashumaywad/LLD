package proj.discountCouponApp.coupon;

import proj.discountCouponApp.cart.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CouponManager {

    private static CouponManager instance;
    private Coupon head;
    private final Lock lock = new ReentrantLock();

    private CouponManager() {}

    public static synchronized CouponManager getInstance() {
        if(instance == null) {
            instance = new CouponManager();
        }
        return instance;
    }

    public void registerCoupon(Coupon coupon) {
        lock.lock();
        try {
            if(head == null) head = coupon;
            else {
                Coupon cur = head;
                while(cur.getNext() != null) cur = cur.getNext();
                cur.setNext(coupon);
            }
        }
        finally {
            lock.unlock();
        }
    }

    public List<String> getApplicable(Cart cart) {
        List<String> res = new ArrayList<>();
        Coupon curr = head;
        while(curr != null) {
            if(curr.isApplicable(cart)) res.add(curr.name());
            curr = curr.getNext();
        }
        return res;
    }

    public double applyAll(Cart cart) {
        if(head != null) head.applyDiscount(cart);
        return cart.getCurrentTotal();
    }
}
