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
                    //displayOrderScreen();
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
                }



            } while(userOrderScreenChoice != 0);


        } catch(Exception e){
            System.out.println("Error");
        }

    }


}
