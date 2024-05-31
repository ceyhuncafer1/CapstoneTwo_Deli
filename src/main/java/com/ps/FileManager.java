package com.ps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileManager {

    private static List<String> usedIds = new ArrayList<>();
    private static Random random = new Random();
    private static String charactersForId = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public void saveReceipt(Order order) {

        String transactionId = createUniqueTransactionId(); // variable to store the return of the method that generates a random string
        LocalDateTime now = LocalDateTime.now(); // variable to store the time this is called
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); // formatting
        String receiptDateTime = now.format(formatter); // variable to store the current time in proper formatting as needed

        String fileName = "receipts/" + receiptDateTime + "-" + transactionId; // folder directory + naming conventions
        File receiptFile = new File(fileName); // file creation

        try (FileWriter writer = new FileWriter(receiptFile)) { // writing inside
            writer.write("Transaction ID: " + transactionId + "\n" + order.toString());
            System.out.println("Receipt was saved: " + fileName);
        } catch (IOException e) {
            System.err.println("Could not save receipt  " + e.getMessage());

        }
    }


    /*

     this createUniqueTransactionId() method doesn't actually do anything in this case since the list of usedId's resets after each run
     However, if this program was to always be running and constantly have orders, not one order id would be the same.
     Also, for the amount of characters I can choose from in the string, to form an 11 digit random id there are a LOT of possibilities.

     */

    private static String createUniqueTransactionId() {

        String id;

        do {
            id = generateRandomString(11);
        } while (usedIds.contains(id)); // keep generating a random string until usedId's doesnt contain the generated string
        usedIds.add(id); // add the new string so it cant be used again
        return id;
    }

    private static String generateRandomString(int length) {

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(charactersForId.charAt(random.nextInt(charactersForId.length())));

            /*
            Take a random index in the string of all possible characters and choose from 0-11 and append that random element to a string.
             */
        }
        return sb.toString();
    }

}
