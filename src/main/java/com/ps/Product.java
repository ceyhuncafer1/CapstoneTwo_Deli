package com.ps;

import java.util.List;

public abstract class Product {

    protected double price;

    public abstract double calcPrice();

    @Override
    public abstract String toString();

}
