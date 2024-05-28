package com.ps;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    int userMenuChoice;

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen(){

        try{

            do{

                System.out.println("1) New Order");
                System.out.println("0) Exit Deli App");

            } while(userMenuChoice != 0);

        } catch(Exception e){
            System.out.println("Error");
        }

    }

}
