package com.ps;

public class Chip extends Product{

    private String chipType;

    public Chip(String chipType){
        this.chipType = chipType;
    }

    @Override
    public double calcPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "chipType='" + chipType + '\'' +
                '}';
    }

}
