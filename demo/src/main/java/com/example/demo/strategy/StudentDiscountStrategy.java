package com.example.demo.strategy;

public class StudentDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }

    @Override
    public String getDiscountName() {
        return "ส่วนลดนักศึกษา (10%)";
    }

}