package com.ps;

public class Chip extends Product{

    private String chipType;

    public Chip(String chipType){
        this.chipType = chipType;
        this.price = calcPrice();
    }

    @Override
    public double calcPrice() {
        return 1.50;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    @Override
    public String toString() {
        return "Chips: " + chipType;

    }
}
