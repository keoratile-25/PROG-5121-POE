/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Login {
    // Array to store users and a counter to track them
    private Details[] userDatabase = new Details[100]; 
    private int userCount = 0; 
    private Scanner scanner = new Scanner(System.in);

    public void registerDetails() {
        if (userCount >= userDatabase.length) {
            System.out.println("Database is full. Cannot register more users at this time.");
            return;
        }

        System.out.print("Enter Your Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Your Surname: ");
        String surname = scanner.nextLine();

        String phone;
        while (true) {
            System.out.print("Enter Number (must start with +27): ");
            phone = scanner.nextLine();
            if (checkCellPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Invalid format. Please use region code (+27) at the beginning.");
            }
        }

        String username;
        while (true) {
            System.out.print("Enter Username (max 8 characters, must contain '!'): ");
            username = scanner.nextLine();
            if (checkUserName(username)) {
                break;
            } else {
                System.out.println("Incorrect username requirements.");
            }
        }

        String password;
        while (true) {
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                break;
            } else {
                System.out.println("Your password is weak. Please ensure there are 10+ characters, 1 uppercase, 1 lowercase, and 1 special character.");
            }
        }

        userDatabase[userCount] = new Details(name, surname, phone, username, password);
        userCount++;
        System.out.println("\nRegistration successful!");
    }

    public boolean returnLoginStatus() {
        System.out.print("Enter Number: ");
        String loginPhone = scanner.nextLine();
        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            Details user = userDatabase[i];
            if (user.number.equals(loginPhone) && user.password.equals(loginPass)) {
                System.out.println("\nWelcome " + user.name + ", " + user.surname + ", it's so nice to meet you!");
                return true;
            }
        }

        System.out.println("\nLogin failed. Check your credentials.");
        return false;
    }

    private boolean checkCellPhoneNumber(String number) {
        return number.startsWith("+27") && number.length() > 3;
    }

    private boolean checkUserName(String username) {
        return username.length() <= 8 && username.contains("!");
    }

    private boolean checkPasswordComplexity(String password) {
        if (password.length() < 10) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasLower && hasSpecial;
    }
}

    

