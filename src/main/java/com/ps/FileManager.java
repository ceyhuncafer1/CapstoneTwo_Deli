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

        String transactionId = createUniqueTransactionId();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String receiptDateTime = now.format(formatter);

        String fileName = "receipts/" + receiptDateTime + "-" + transactionId;
        File receiptFile = new File(fileName);

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write("Transaction ID: " + transactionId + "\n" + order.toString());
            System.out.println("Receipt was saved: " + fileName);
        } catch (IOException e) {
            System.err.println("Could not save receipt  " + e.getMessage());

        }
    }

    private static String createUniqueTransactionId() {

        String id;
        do {
            id = generateRandomString(11);
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }

    private static String generateRandomString(int length) {

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(charactersForId.charAt(random.nextInt(charactersForId.length())));
        }
        return sb.toString();
    }

}
