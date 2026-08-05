package com.example.demo.strategy;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(double price) {
        return price;
    }

    @Override
    public String getDiscountName() {
        return "ราคาปกติ";
    }

}