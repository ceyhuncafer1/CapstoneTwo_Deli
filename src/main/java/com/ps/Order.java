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

        String receiptOutput = "Order details:\n";
        double totalCost = 0;

        for (Product product : products) {
            double productPrice = product.calcPrice();
            receiptOutput += product + " - Price: $" + productPrice + "\n";
            totalCost += productPrice;
        }

        receiptOutput += "Total order cost: $" + totalCost + "\n";
        return receiptOutput;

    }
}
