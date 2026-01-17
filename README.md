# Discount Coupon Engine (Java)

A modular, extensible discount and coupon engine built using core Java design patterns.
This project demonstrates how multiple discounts can be applied sequentially on a shopping cart using Strategy, Chain of Responsibility, and Singleton patterns.

---

## Features

- Supports multiple discount types
  - Seasonal category discounts
  - Loyalty discounts
  - Bulk purchase discounts
  - Bank-specific offers with caps
- Discounts can be combined or stopped
- Thread-safe coupon registration
- Clean separation of domain, behavior, and orchestration
- Easily extensible without modifying existing code (Open/Closed Principle)

---

## Design Patterns Used

| Pattern | Purpose |
|------|-------|
| Strategy Pattern | Encapsulates discount calculation logic |
| Chain of Responsibility | Applies coupons sequentially |
| Singleton Pattern | Centralized managers |
| Composition | Cart → CartItem → Product |
| SOLID (OCP) | New coupons added without changing core logic |

---

## Project Structure

```
src/main/java/com/example/discount
├── DiscountCouponApplication.java
├── cart
│   ├── Cart.java
│   ├── CartItem.java
│   └── Product.java
├── coupon
│   ├── Coupon.java
│   ├── SeasonalOffer.java
│   ├── LoyaltyDiscount.java
│   ├── BulkPurchaseDiscount.java
│   └── BankingCoupon.java
│   └── CouponManager.java
└── strategy
    ├── DiscountStrategy.java
    ├── FlatDiscountStrategy.java
    ├── PercentageDiscountStrategy.java
    ├── PercentageWithCapStrategy.java
    ├── StrategyType.java
    └── DiscountStrategyManager.java
```

---

## Supported Coupons

### Seasonal Offer
- Percentage discount on a specific product category

### Loyalty Discount
- Percentage discount for loyalty members

### Bulk Purchase Discount
- Flat discount when cart total exceeds a threshold

### Banking Coupon
- Percentage discount with a maximum cap
- Applied only for specific bank payments

---

## Discount Flow

1. Products are added to the cart
2. Coupons are registered in CouponManager
3. Applicable coupons are identified
4. Coupons are applied in order
5. Each coupon updates the cart total
6. Final payable amount is calculated

---

## How to Run

### Prerequisites
- Java 8 or higher
- Any IDE (IntelliJ IDEA recommended)

### Steps
```bash
git clone https://github.com/ashumaywad/LLD.git
cd LLD/discountCouponApp
```

Run:
```
DiscountCouponApplication.java
```

---

## Sample Output

```
Original Cart Total: 25000.0 Rs
Applicable Coupons:
 - Seasonal Offer 10% off Clothing
 - Loyalty Discount 5% off
 - Bulk Purchase Rs 100 off over 1000
 - ABC Bank Rs 15 off upto 500
Seasonal Offer 10% off Clothing applied: 300.0
Loyalty Discount 5% off applied: 1235.0
Bulk Purchase Rs 100 off over 1000 applied: 100.0
ABC Bank Rs 15 off upto 500 applied: 500.0
Final Cart Total after discounts: 22865.0 Rs
```

---

## Extending the System

### Add a New Coupon
1. Extend Coupon
2. Implement isApplicable() and getDiscount()
3. Register it in CouponManager

No existing code needs to be modified.
