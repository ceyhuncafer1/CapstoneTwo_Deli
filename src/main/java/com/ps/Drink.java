package com.ps;

public class Drink extends Product{

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        calcPrice(); // we must initialize the price of the drink based on it's size when we create a new Drink object
    }

    @Override
    public double calcPrice() {

        switch (size) {
            case "Small":
                price = 2.00;
                break;
            case "Medium":
                price = 2.50;
                break;
            case "Large":
                price = 3.00;
                break;
        }

        return price;
    }

    @Override
    public String toString() {
        return "Drink: " + size + " " + flavor;
    }
}
