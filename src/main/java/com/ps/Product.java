package com.ps;

public abstract class Product {

    /*
    All products have these same properties in common
    for example, calcPrice() must be in the subclasses and all have their own calcPrice() method with their own prices
    for unique customization options. We can make the methods for these in the subclasses and calculate it in
    the subclass calcPrice() and return it to product and iterate through it to get a total for every product in the current order.
     */

    protected double price;

    public abstract double calcPrice();

    @Override
    public abstract String toString();

}
