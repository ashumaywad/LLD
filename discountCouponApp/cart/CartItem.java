package proj.discountCouponApp.cart;

public class CartItem {

    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double itemTotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return this.product;
    }
}
