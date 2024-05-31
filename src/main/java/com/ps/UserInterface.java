package com.ps;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {



    private Scanner scanner;
    private Order currentOrder; // we must have a variable of type Order to act as a folder for all of the products and also for the ongoing order
    int userHomeScreenChoice;
    int userOrderScreenChoice;

    // colored text
    String BLUE = "\u001B[34m";
    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String RESET = "\u001B[0m";

    //initialize object
    public UserInterface(){ // constructor
        scanner = new Scanner(System.in);
        currentOrder = new Order();
    }

    public void displayHomeScreen() {

        boolean validInput = false; // flag to check input is valid

        // we will keep doing this until the user enters a proper input
        do {
            System.out.println("Welcome to DELI-CIOUS!"); // home screen
            System.out.println("Pick an option:");
            System.out.println("1) New Order");
            System.out.println("0) Exit Deli App");

            try {

                userHomeScreenChoice = scanner.nextInt();
                scanner.nextLine();// .nextInt() makes it so theres an empty space. this gets rid of it, so it actually reads the user's next input

                //if the input is 1 or 0 we will let them go to these cases. (error handling)
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

        boolean ordering = true; // control loop, break if they want to cancel order or checkout

        // keep displaying this screen until user cancels order or checks out
        while (ordering) {

            // order menu
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
                        Sandwich sandwich = createSandwich(); // instance of Sandwich class called sandwich equals createSandwich() which returns sandwich object with new properties
                        currentOrder.addProduct(sandwich); // sandwich object is then added to currentOrder using addProduct() in Order class
                        printCurrentOrder(); // users current order printed to screen
                        break;
                    case 2:
                        Drink drink = createDrink();
                        currentOrder.addProduct(drink);
                        printCurrentOrder();
                        break;
                    case 3:
                        Chip chip = createChip();
                        currentOrder.addProduct(chip);
                        printCurrentOrder();
                        break;
                    case 4:
                        checkout();
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

        // declare sandwich object to be returned by this method
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
                        System.out.println("Bread type does not exist. Please try again."); // if the user choice isn't 1-4 print this
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (breadType == null); // continue looping until case 1-4 is selected which will make breadType not null and exit the loop

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

        sandwich = new Sandwich(size, breadType); // our sandwich constructor takes the two parameters (size, breadType) to be made, so we will now make it with this information and continue on with the rest of its properties

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int meatCount = 0; // counter for number of meats user selects
        int maxMeatCount = 6; // if it hits 6 we will force stop user and go to next screen
        boolean addingMeat = true; // flag in case user is done after 1 and wants to exit screen earlier
        String meatType = null;
        boolean extraForMeat = false; // is extra meat requested
        boolean validInput = false;


        System.out.println("You will now choose your meat-based toppings: ");

        do {

            System.out.println("1) Steak");
            System.out.println("2) Ham");
            System.out.println("3) Salami");
            System.out.println("4) Roast Beef");
            System.out.println("5) Chicken");
            System.out.println("6) Bacon");
            System.out.println("0) Done");

            try {
                int meatChoice = scanner.nextInt();
                scanner.nextLine();

                switch (meatChoice) {
                    case 1:
                        meatType = "Steak";
                        System.out.println("You picked: Steak");
                        break;
                    case 2:
                        meatType = "Ham";
                        System.out.println("You picked: Ham");
                        break;
                    case 3:
                        meatType = "Salami";
                        System.out.println("You picked: Salami");
                        break;
                    case 4:
                        meatType = "Roast Beef";
                        System.out.println("You picked: Roast Beef");
                        break;
                    case 5:
                        meatType = "Chicken";
                        System.out.println("You picked: Chicken");
                        break;
                    case 6:
                        meatType = "Bacon";
                        System.out.println("You picked: Bacon");
                        break;
                    case 0:
                        addingMeat = false;
                        break;
                    default:
                        System.out.println("Invalid meat choice. Try again.");
                        continue;
                }

                if(meatChoice != 0){

                    do {
                        System.out.println("Do you want extra meat? (1 = yes , 0 = no)");
                        try {
                            int extraChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (extraChoice == 1) {

                                extraForMeat = true;
                                validInput = true;

                            } else if (extraChoice == 0) {

                                extraForMeat = false;
                                validInput = true;

                            } else {
                                System.out.println("Invalid choice. Please enter 1 or 0.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid type. Please enter a number.");
                            scanner.next();
                        }
                    } while (!validInput);

                }

                if (meatChoice >= 1 && meatChoice <= 6) {
                    meatCount++;
                }

                if (meatCount >= maxMeatCount) {
                    System.out.println("You have reached the maximum number of meat-based toppings.");
                    addingMeat = false;
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid Type - must be an integer");
                scanner.next();
            }



        } while (addingMeat);

        sandwich.addMeat(meatType, extraForMeat); // add properties to  sandwich

        System.out.println("You have finished selecting meat-based toppings.");

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //same as meat and meat extra
        String cheeseType = null;
        int cheeseCount = 0;
        int maxCheeseCount = 4;
        boolean addingCheese = true;
        boolean extraForCheese = false;
        boolean validInputForCheese = false;

        System.out.println("Pick your cheese:");

        do{

            System.out.println("1) Cheddar");
            System.out.println("2) Mozzarella");
            System.out.println("3) Gouda");
            System.out.println("4) Provolone");
            System.out.println("5) None");
            System.out.println("0) Done ");

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
                    case 0:
                        addingCheese = false;
                        break;
                    default:
                        System.out.println("Invalid cheese choice. Make sure you pick an option that is listed.");
                        continue;

                }

                if(cheeseChoice != 0){

                    do{
                        System.out.println("Do you want extra cheese? (1 = yes , 0 = no)");
                        try{
                            int extraChoice = scanner.nextInt();
                            scanner.nextLine();

                            if(extraChoice == 1){

                                extraForCheese = true;
                                validInputForCheese = true;

                            }else if(extraChoice == 0){

                                extraForCheese = false;
                                validInputForCheese = true;

                            } else{
                                System.out.println("Make sure you pick 0 or 1");
                            }
                        } catch(InputMismatchException e){
                            System.out.println("Invalid type.");
                            scanner.next();
                        }

                    } while(!validInputForCheese);

                }

                if (cheeseChoice >= 1 && cheeseChoice <= 6) {
                    cheeseCount++;
                }

                if (cheeseCount >= maxCheeseCount) {
                    System.out.println("You have reached the maximum number of cheese toppings.");
                    addingCheese = false;
                }

            } catch(InputMismatchException e){
                System.out.println("Invalid type error");
                scanner.next();
            }



        } while(addingCheese);

        sandwich.addCheese(cheeseType, extraForCheese);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // same and meat and meat extra, however there is no limit on the amount of toppings so the user will end up pressing 0 to get out of this screen
        String toppingType = null;
        boolean addingToppings = true;

        System.out.println("You will now choose your regular toppings: (Press 0 when you are done)");

        do {

            System.out.println("1) Lettuce");
            System.out.println("2) Peppers");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapenos");
            System.out.println("6) Cucumbers");
            System.out.println("7) Pickles");
            System.out.println("8) Guacamole");
            System.out.println("9) Mushrooms");
            System.out.println("0) Done selecting toppings");

            try {
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();

                switch (toppingChoice) {
                    case 1:
                        toppingType = "Lettuce";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 2:
                        toppingType = "Peppers";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 3:
                        toppingType = "Onions";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 4:
                        toppingType = "Tomatoes";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 5:
                        toppingType = "Jalapenos";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 6:
                        toppingType = "Cucumbers";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 7:
                        toppingType = "Pickles";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 8:
                        toppingType = "Guacamole";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 9:
                        toppingType = "Mushrooms";
                        sandwich.addRegularTopping(toppingType);
                        break;
                    case 0:
                        addingToppings = false;
                        break;
                    default:
                        System.out.println("Topping choice does not exist. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Type - must be an integer");
                scanner.next();
            }

        } while (addingToppings); // while this is true it will keep asking them what toppings they want. when they press 0 break out of loop and go to next screen

        System.out.println("You have finished selecting regular toppings.");

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

        sandwich.addSauce(sauceType); // add property

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean isToasted = false;
        boolean validInputForToast = false;

        do{

            System.out.println("Do you want your sandwich toasted? (1 = yes , 0 = no)");

            try{

                int extraChoice = scanner.nextInt();
                scanner.nextLine();

                if(extraChoice == 1){

                    isToasted = true;
                    validInputForToast = true;

                }else if(extraChoice == 0){

                    isToasted = false;
                    validInputForToast = true;

                } else{
                    System.out.println("Make sure you pick 0 or 1");
                }
            } catch(InputMismatchException e){
                System.out.println("Invalid type.");
                scanner.next();
            }

        } while(!validInputForToast);

        sandwich.setToasted(isToasted);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String sideType = null;

        do{

            System.out.println("You will now choose your sides: ");
            System.out.println("1) Au jus");
            System.out.println("2) Extra sauce");
            System.out.println("3) Nothing");

            try{

                int sideChoice = scanner.nextInt();
                scanner.nextLine();

                switch (sideChoice) {
                    case 1:
                        sideType = "Au jus";
                        break;
                    case 2:
                        sideType = "Extra sauce";
                        break;
                    case 3:
                        sideType = "Nothing";
                        break;
                    default:
                        System.out.println("Invalid side choice. Try again.");
                }

            } catch(InputMismatchException e){
                System.out.println("Invalid Type - must be an integer");
                scanner.next();
            }

        } while(sideType == null);

        sandwich.addSide(sideType);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return sandwich;
    }

    private Drink createDrink() {

        String size = null;
        String flavor = null;

        do {

            System.out.println("Select drink size:");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");

            try {
                int sizeChoice = scanner.nextInt();
                scanner.nextLine();

                switch (sizeChoice) {
                    case 1:
                        size = "Small";
                        break;
                    case 2:
                        size = "Medium";
                        break;
                    case 3:
                        size = "Large";
                        break;
                    default:
                        System.out.println("Size does not exist. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Make sure you enter a number.");
                scanner.next();
            }
        } while (size == null);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        do {

            System.out.println("Select the flavor for your drink:");
            System.out.println("1) Coke");
            System.out.println("2) Fanta");
            System.out.println("3) Hi-C");
            System.out.println("4) Dr. Pepper");
            System.out.println("5) Pepsi");
            System.out.println("6) Sprite");

            try {
                int flavorChoice = scanner.nextInt();
                scanner.nextLine();

                switch (flavorChoice) {
                    case 1:
                        flavor = "Coke";
                        break;
                    case 2:
                        flavor = "Fanta";
                        break;
                    case 3:
                        flavor = "Hi-C";
                        break;
                    case 4:
                        flavor = "Dr. Pepper";
                        break;
                    case 5:
                        flavor = "Pepsi";
                        break;
                    case 6:
                        flavor = "Sprite";
                        break;
                    default:
                        System.out.println("Flavor does not exist. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Make sure you enter a number.");
                scanner.next();
            }
        } while (flavor == null);

        return new Drink(size, flavor);
    }

    private Chip createChip() {

        String chipType = null;

        do {

            System.out.println("Select the type of chips you want:");
            System.out.println("1) Lays BBQ");
            System.out.println("2) Cheetos Crunchy");
            System.out.println("3) Ruffles Sour Cream and Onion");
            System.out.println("4) Ruffles Cheddar Cheese");
            System.out.println("5) Sun Chips Classic");

            try {
                int chipChoice = scanner.nextInt();
                scanner.nextLine();

                switch (chipChoice) {
                    case 1:
                        chipType = "Lays BBQ";
                        break;
                    case 2:
                        chipType = "Cheetos Crunchy";
                        break;
                    case 3:
                        chipType = "Ruffles Sour Cream and Onion";
                        break;
                    case 4:
                        chipType = "Ruffles Cheddar Cheese";
                        break;
                    case 5:
                        chipType = "Sun Chips Classic";
                        break;
                    default:
                        System.out.println("Chip type does not exist. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Make sure you enter a number.");
                scanner.next();
            }
        } while (chipType == null);

        return new Chip(chipType); // constructor parameter requires only chipType
    }

    private void printCurrentOrder() {

        List<Product> products = currentOrder.getProducts(); // create a list of products based on the currentOrder using .getProducts()

        System.out.println("\nYour Current Order:");
        System.out.println("-------------------------------");

        double totalCost = 0; // will be used to store total cost of all products in this products list

        for (int i = products.size() - 1; i >= 0; i--) { // length of the products list, so for example if they have 1 sandwich size = 1  and i-- will go to 0 in 1 iteration and only print the sandwich.
            Product product = products.get(i); // access each individual product object in the products list during the loop's iteration
            double productPrice = product.calcPrice();

            /*
            calcPrice() is an abstract class in Product meaning it will not have any implementation but it means
            it must be implemented in the subclasses (Sandwich, Drink, Chip)
            So basically it just calculates the price of each product as each product has unique prices.
            We use total cost with that defined in this scope to easily get the total cost.

             */
            System.out.printf("%-1s " + GREEN + "$%.2f" + RESET + "%n", product, productPrice);
            totalCost += productPrice;
        }

        System.out.println("-------------------------------");
        System.out.printf("Total: " + GREEN + "$%.2f" + RESET + "%n", totalCost);
        System.out.println();
    }

    private void checkout(){

        printCurrentOrder();

        System.out.println(BLUE + "1) Confirm Order" + RESET);
        System.out.println(RED + "2) Cancel - Delete Order" + RESET);

        int ans = scanner.nextInt();

        if (ans == 1) {

            /*
            If user confirms the order we must create a new instance of the fileManager class
            this instance will be called by the saveReceipt() method which takes in the parameters of the current order
            We need the current order as a parameter to call its methods like .toString() to put on the receipt for relevant information.
             */

            FileManager receiptFileManager = new FileManager();
            receiptFileManager.saveReceipt(currentOrder);
            System.out.println("Order confirmed and receipt saved.");
            currentOrder = new Order(); // clear current order and go back to home screen

        } else {
            System.out.println("Order cancelled.");
            currentOrder = new Order();
        }

        displayHomeScreen();

    }
}