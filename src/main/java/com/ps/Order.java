package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products; // store all the products to add and get products

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

        /*
        UserInterface calls FileManager which takes a parameter of the current order which we then can now use the .toString() and
        retrieve the current order and print it to the receipt.
         */

        String receiptOutput = "Order details:\n";
        double totalCost = 0;

        for (Product product : products) {

            double productPrice = product.calcPrice(); // refer to product class
            receiptOutput += product + " - Price: $" + productPrice + "\n";
            totalCost += productPrice;

        }

        receiptOutput += "\nTotal order cost: $" + totalCost + "\n";
        return receiptOutput;

    }
}
