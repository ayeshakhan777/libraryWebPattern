/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import DAO.UserDAO;
import Dtos.User;
import java.util.Scanner;

/**
 *
 * @author Sean
 */
public class LibraryWebPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User();
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            // Find out what the user wishes to do
            choice = getMenuChoice(input, user);
            
            switch (choice) {

                case 1:
                    UserDAO login = new UserDAO();
                    System.out.println("Please enter your email:");
                    String email = input.nextLine();
                    
                    System.out.println("Please enter your password:");
                    String password = input.nextLine();
                    
                    int userID = login.login(email, password);
                    
                    if(userID != 0) {
                        System.out.println("Login successful!");
                        user = login.findUserByID(userID);
                        System.out.println("Welcome " + user.getFirstName() + "!");
                    } else {
                        System.out.println("Please try again");
                    }
                    
                    break;
            }

            if (choice == 0) {
                System.out.println("Are you sure you want to exit? (Y/N)");
                String confirmation = input.nextLine();
                if (!confirmation.equalsIgnoreCase("y")) {
                    System.out.println("Ok, continuing program!");
                    choice = -1;
                } else {
                    System.out.println("Thank you for using the Library Client application.");
                }

            }

        }
    }

    public static int getMenuChoice(Scanner sc,User user) {
        int choice = -1;
        while (choice < 0 || choice > 13) {
            System.out.println("Please select one of the following options:");
            System.out.println("0) Exit the application");
            System.out.println("1) Login");
            System.out.println("2) Sign up");
            System.out.println("3) View all books");
            System.out.println("4) View details of a book");
                    if(user.getUserID() != 0) {
                        System.out.println("");
                        System.out.println("-USER CONTROLS-");
                        System.out.println("5) Borrow a book");
                        System.out.println("6) View borrowed books");
                        System.out.println("7) Return borrowed book(s)");
                        System.out.println("8) Log out"); 
                   }
                        if(user.getIsAdmin() == 1) {
                            System.out.println("");
                            System.out.println("-ADMIN CONTROLS-");
                            System.out.println("9) Add title");
                            System.out.println("10) Change title details");
                            System.out.println("11) Change title stock levels");
                            System.out.println("12) Remove title");
                            System.out.println("13) Remove user");
                        }
            
            choice = sc.nextInt();
        }
        sc.nextLine();
        return choice;
    }
}
