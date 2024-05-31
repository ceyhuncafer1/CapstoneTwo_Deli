package com.ps;

public abstract class Product {

    protected double price;

    public abstract double calcPrice();

    @Override
    public abstract String toString();

}
