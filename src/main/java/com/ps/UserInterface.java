package com.ps;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    int userHomeScreenChoice;
    int userOrderScreenChoice;

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen(){

        try{

            do{

                System.out.println("Pick an option");
                System.out.println("1) New Order");
                System.out.println("0) Exit Deli App");

                userHomeScreenChoice = scanner.nextInt();
                scanner.nextLine();

                if(userHomeScreenChoice == 1){
                    displayOrderScreen();
                }



            } while(userHomeScreenChoice != 0);

        } catch(Exception e){
            System.out.println("Error");
        }

    }

    public void displayOrderScreen(){

        try{

            do{

                System.out.println("1) Add Sandwich");
                System.out.println("2) Add Drink");
                System.out.println("3) Add Chips");
                System.out.println("4) Checkout");
                System.out.println("0) Cancel Order");

                userOrderScreenChoice = scanner.nextInt();
                scanner.nextLine();

                switch(userOrderScreenChoice){
                    case 1:
                        // Goal is to make an instance of THIS sandwich for THIS order for THIS product. Need to instantiate a new order.
                        Sandwich sandwich = createSandwich();
                        break;
                }



            } while(userOrderScreenChoice != 0);


        } catch(Exception e){
            System.out.println("Error");
        }

    }

    private Sandwich createSandwich() {

        Sandwich sandwich = null;
        try {

            System.out.println("Select your bread:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");

            int breadChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String breadType = null;

            switch (breadChoice) {
                case 1:
                    breadType = "White";
                    break;
                case 2:
                    breadType = "Wheat";
                    break;
                case 3:
                    breadType = "Rye";
                    break;
                case 4:
                    breadType = "Wrap";
                    break;
            }

            ///////////////////////////////////////////////

            System.out.println("Select sandwich size:");
            System.out.println("1) 4\"");
            System.out.println("2) 8\"");
            System.out.println("3) 12\"");

            int sizeChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            int size = 0;

            switch (sizeChoice) {
                case 1:
                    size = 4;
                    break;
                case 2:
                    size = 8;
                    break;
                case 3:
                    size = 12;
                    break;
            }

            sandwich = new Sandwich(size, breadType);
            System.out.println(sandwich);

        } catch (Exception e) {
            System.out.println("error");
        }

        return sandwich;


    }
}
