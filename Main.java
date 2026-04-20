/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login(); // Instantiate the login system

        while (true) {
            System.out.println("\n--- Chat App System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                loginSystem.registerDetails();
            } else if (choice.equals("2")) {
                loginSystem.returnLoginStatus();
            } else if (choice.equals("3")) {
                System.out.println("Thank You & Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        
        scanner.close();
    }
}

    
    

