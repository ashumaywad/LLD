package proj.discountCouponApp.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<CartItem> items = new ArrayList<>();
    private double originalTotal;
    private double currentTotal;
    private boolean loyaltyMember;
    private String paymentBank;

    public void addProduct(Product product, int qty) {
        CartItem item = new CartItem(product, qty);
        items.add(item);
        originalTotal += item.itemTotal();
        currentTotal += item.itemTotal();
    }

    public void applyDiscount(double discount) {
        currentTotal = Math.max(0, currentTotal - discount);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getOriginalTotal() {
        return originalTotal;
    }

    public double getCurrentTotal() {
        return currentTotal;
    }

    public boolean isLoyaltyMember() {
        return loyaltyMember;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setLoyaltyMember(boolean loyaltyMember) {
        this.loyaltyMember = loyaltyMember;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }
}
