package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;

    public Order(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                '}';
    }
}
