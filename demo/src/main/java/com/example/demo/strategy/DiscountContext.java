package com.example.demo.strategy;

public class DiscountContext {

    public DiscountStrategy getStrategy(String discountType) {

        if (discountType == null) {
            return new NoDiscountStrategy();
        }

        switch (discountType.toUpperCase()) {

            case "STUDENT":
                return new StudentDiscountStrategy();

            case "SEASONAL":
                return new SeasonalSaleStrategy();

            case "NONE":
            default:
                return new NoDiscountStrategy();
        }
    }

    public double calculatePrice(double price, String discountType) {
        return getStrategy(discountType).calculatePrice(price);
    }

    public String getDiscountName(String discountType) {
        return getStrategy(discountType).getDiscountName();
    }

}