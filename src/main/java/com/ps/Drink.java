package com.ps;

public class Drink extends Product{

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        calcPrice();
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
        return "Drink{" +
                "size='" + size + '\'' +
                ", flavor='" + flavor + '\'' +
                ", price=" + price +
                '}';
    }
}
