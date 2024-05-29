package com.ps;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Order currentOrder;
    int userHomeScreenChoice;
    int userOrderScreenChoice;

    public UserInterface(){
        scanner = new Scanner(System.in);
        currentOrder = new Order();
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
                            System.out.println("Quitting DELI-CIOUS Sandwiches!");
                            break;
                    }
                } else {
                    System.out.println("Option does not exist. Please select 1 or 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Make sure you choose a number.");
                scanner.next();
            }
        } while (!validInput);
    }

    public void displayOrderScreen() {

        List<Sandwich> sandwiches = new ArrayList<>();
        boolean ordering = true;

        while (ordering) {

            System.out.println("Order Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            try {
                userOrderScreenChoice = scanner.nextInt();
                scanner.nextLine();

                switch (userOrderScreenChoice) {
                    case 1:
                        Sandwich sandwich = createSandwich();
                        currentOrder.addProduct(sandwich);
                        break;
                    case 2:
                        //drinks
                        break;
                    case 3:
                        //chips
                        break;
                    case 4:
                        //checkout
                        ordering = false;
                        break;
                    case 0:
                        ordering = false;
                        break;
                    default:
                        System.out.println("The number you chose is not on the screen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("You typed a data type other than an integer. Make sure you pick either 1, 2, 3, 4, or 0");
                scanner.next();
            }
        }
    }

    private Sandwich createSandwich() {

        Sandwich sandwich;
        String breadType = null;
        int size = 0;

        do {
            System.out.println("Select your bread:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");

            try {

                int breadChoice = scanner.nextInt();
                scanner.nextLine();

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
                        System.out.println("Bread type does not exist. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (breadType == null);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        do {
            System.out.println("Select sandwich size:");
            System.out.println("1) 4 inch");
            System.out.println("2) 8 inch");
            System.out.println("3) 12 inch");

            try {
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
                        System.out.println("Size does not exist. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (size == 0);

        sandwich = new Sandwich(size, breadType);
        String meatType = null;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        do{
            System.out.println("You will now choose your meat-based toppings ");
            System.out.println("1) Steak");
            System.out.println("2) Ham");
            System.out.println("3) Salami");
            System.out.println("4) Roast Beef");
            System.out.println("5) Chicken");
            System.out.println("6) Bacon");
            System.out.println("7) Vegetarian");

            try{

                int meatChoice = scanner.nextInt();
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
                    case 7:
                        meatType = "Vegetarian";
                    default:
                        System.out.println("Invalid meat choice. Try again.");

                }

            } catch(InputMismatchException e){
                System.out.println("Invalid Type - must be an integer");
                scanner.next();
            }

        } while(meatType == null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean extraForMeat = false;
        
        do{
            System.out.println("Do you want extra meat? (1 = yes , 0 = no)");
            try{
                int extraChoice = scanner.nextInt();
                scanner.nextLine();

                if(extraChoice == 1){
                    extraForMeat = true;
                }else
                    extraForMeat = false;
                
            } catch(InputMismatchException e){
                System.out.println("Invalid type.");
                scanner.next();
            }

        } while(!extraForMeat);

        sandwich.addMeat(meatType, extraForMeat);

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String cheeseType = null;

        do{

            System.out.println("Pick your cheese:");
            System.out.println("1) Cheddar");
            System.out.println("2) Mozzarella");
            System.out.println("3) Gouda");
            System.out.println("4) Provolone");
            System.out.println("5) None");

            try{

                int cheeseChoice = scanner.nextInt();
                scanner.nextLine();

                switch (cheeseChoice) {
                    case 1:
                        cheeseType = "Cheddar";
                        break;
                    case 2:
                        cheeseType = "Mozzarella";
                        break;
                    case 3:
                        cheeseType = "Gouda";
                        break;
                    case 4:
                        cheeseType = "Provolone";
                        break;
                    case 5:
                        cheeseType = "None";
                        break;
                    default:
                        System.out.println("Invalid cheese choice. Try again.");

                }

            } catch(InputMismatchException e){
                System.out.println("Invalid type error");
                scanner.next();
            }

        } while(cheeseType == null);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean extraForCheese = false;

        do{
            System.out.println("Do you want extra cheese? (1 = yes , 0 = no)");
            try{
                int extraChoice = scanner.nextInt();
                scanner.nextLine();

                if(extraChoice == 1){
                    extraForCheese = true;
                }else
                    extraForCheese = false;
            } catch(InputMismatchException e){
                System.out.println("Invalid type.");
                scanner.next();
            }

        } while(!extraForCheese);

        sandwich.addCheese(cheeseType, extraForMeat);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

       String toppingType = null;

        do{

            System.out.println("You will now choose your regular toppings: ");
            System.out.println("1) Lettuce");
            System.out.println("2) Peppers");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapenos");
            System.out.println("6) Cucumbers");
            System.out.println("7) Pickles");
            System.out.println("8) Guacamole");
            System.out.println("9) Mushrooms");

            try{

                int toppingChoice = scanner.nextInt();
                scanner.nextLine();

                switch (toppingChoice) {
                    case 1:
                        toppingType = "Lettuce";
                        break;
                    case 2:
                        toppingType = "Peppers";
                        break;
                    case 3:
                        toppingType = "Onions";
                        break;
                    case 4:
                        toppingType = "Tomatoes";
                        break;
                    case 5:
                        toppingType = "Jalapenos";
                        break;
                    case 6:
                        toppingType = "Cucumbers";
                        break;
                    case 7:
                        toppingType = "Pickles";
                        break;
                    case 8:
                        toppingType = "Guacamole";
                        break;
                    case 9:
                        toppingType = "Mushrooms";
                        break;
                    default:
                        System.out.println("Invalid regular topping choice. Try again.");

                }

            } catch(InputMismatchException e){
                System.out.println("Invalid Type - must be an integer");
                scanner.next();
            }

        } while(toppingType == null);

        sandwich.addRegularTopping(toppingType);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String sauceType = null;

        do{

            System.out.println("You will now choose your sauces: ");
            System.out.println("1) Mayonnaise");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Island");
            System.out.println("6) Vinaigrette");
            System.out.println("7) None");

            try{

                int sauceChoice = scanner.nextInt();
                scanner.nextLine();

                switch (sauceChoice) {
                    case 1:
                        sauceType = "Mayonnaise";
                        break;
                    case 2:
                        sauceType = "Mustard";
                        break;
                    case 3:
                        sauceType = "Ketchup";
                        break;
                    case 4:
                        sauceType = "Ranch";
                        break;
                    case 5:
                        sauceType = "Thousand Island";
                        break;
                    case 6:
                        sauceType = "Vinaigrette";
                        break;
                    case 7:
                        sauceType = "None";
                        break;
                    default:
                        System.out.println("Invalid sauce choice. Try again.");

                }

            } catch(InputMismatchException e){
                System.out.println("Invalid Type - must be an integer");
                scanner.next();
            }

        } while(sauceType == null);

        sandwich.addSauce(sauceType);

        System.out.println(sandwich);
        return sandwich;
    }

}
