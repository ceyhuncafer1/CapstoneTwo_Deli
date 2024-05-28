package com.ps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    int userHomeScreenChoice;
    int userOrderScreenChoice;

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {
        boolean validInput = false;

        do {
            System.out.println("Pick an option:");
            System.out.println("1) New Order");
            System.out.println("0) Exit Deli App");

            try {
                userHomeScreenChoice = scanner.nextInt();
                scanner.nextLine();

                if (userHomeScreenChoice == 1 || userHomeScreenChoice == 0) {
                    validInput = true;
                    switch (userHomeScreenChoice) {
                        case 1:
                            displayOrderScreen();
                            break;
                        case 0:
                            System.out.println("Exiting Deli App :(");
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please select 1 or 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (!validInput);
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
                    default:
                        System.out.println("Invalid option");
                }



            } while(userOrderScreenChoice != 0);


        } catch(Exception e){
            System.out.println("Error");
        }

    }

    private Sandwich createSandwich() {

        Sandwich sandwich = null;
        String breadType = null;
        int size = 0;

        try {

            do {

                System.out.println("Select your bread:");
                System.out.println("1) White");
                System.out.println("2) Wheat");
                System.out.println("3) Rye");
                System.out.println("4) Wrap");

                int breadChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline

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
                    default:
                        System.out.println("Bread does not exist. Please try again");
                }

            } while (breadType == null);

        } catch(Exception e){
            System.out.println("Error for bread type");
        }

            ///////////////////////////////////////////////

        try {
            do {

                System.out.println("Select sandwich size:");
                System.out.println("1) 4\"");
                System.out.println("2) 8\"");
                System.out.println("3) 12\"");

                int sizeChoice = scanner.nextInt();
                scanner.nextLine();

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
                    default:
                        System.out.println("Size does not exist. Please try again");
                }

            } while (size == 0);

            sandwich = new Sandwich(size, breadType);

        } catch(Exception e) {
            System.out.println("Error for size");
        }

            //////////////////////////////////////////////////////////////////////////

            int meatChoice = 0;
            String meatType = null;
            boolean extra = false;

            try {

                do {

                    System.out.println("Pick a meat:");
                    System.out.println("1) Steak");
                    System.out.println("2) Ham");
                    System.out.println("3) Salami");
                    System.out.println("4) Roast Beef");
                    System.out.println("5) Chicken");
                    System.out.println("6) Bacon");

                    meatChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (meatChoice) {
                        case 1:
                            meatType = "Steak";
                            break;
                        case 2:
                            meatType = "Ham";
                            break;
                        case 3:
                            meatType = "Salami";
                            break;
                        case 4:
                            meatType = "Roast Beef";
                            break;
                        case 5:
                            meatType = "Chicken";
                            break;
                        case 6:
                            meatType = "Bacon";
                            break;
                        default:
                            System.out.println("Invalid meat choice. Try again.");

                    }

                    //System.out.println("Do you want extra meat? (1 = yes , 0 = no)");
                    // int extraChoice = scanner.nextInt();

                    // if (extraChoice == 1) {
                    //     extra = true;
                    //  } else
                    //     extra = false;

                } while (meatType == null);
            } catch(Exception e) {
                System.out.println("Error for meat type");}

            //sandwich.addMeat(meatType, extra);
            System.out.println(sandwich);


        return sandwich;
    }
}
