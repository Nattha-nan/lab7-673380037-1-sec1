package com.example.demo.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }

    @Override
    public String getDiscountName() {
        return "ส่วนลดเทศกาล (20%)";
    }

}