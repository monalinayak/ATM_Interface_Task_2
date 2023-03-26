/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atm;

/**
 *
 * @author monalinayak
 */
import java.util.Scanner;

public class ATM 
{
    private static final String[] TRANSACTIONS = {"Deposit", "Withdrawal", "Transfer"};

    private static String userId = "user123";
    private static String userPin = "1234";
    private static double balance = 1000.00;
    private static String transactionHistory = "";

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.println("Please enter your user id: ");
        String inputId = scanner.nextLine();
        System.out.println("Please enter your user pin: ");
        String inputPin = scanner.nextLine();

        if (inputId.equals(userId) && inputPin.equals(userPin)) {
            System.out.println("Login successful.");
            boolean isRunning = true;
            while (isRunning) 
            {
                System.out.println("\nSelect an option:");
                System.out.println("1. View transaction history");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        viewTransactionHistory();
                        break;
                    case 2:
                        withdraw(scanner);
                        break;
                    case 3:
                        deposit(scanner);
                        break;
                    case 4:
                        transfer(scanner);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid user id or pin. Please try again.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.println("Transaction history:");
        System.out.println(transactionHistory);
    }

    private static void withdraw(Scanner scanner) {
        System.out.println("Please enter the amount to withdraw:");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            String transaction = String.format("%s of %.2f withdrawn\n", TRANSACTIONS[1], amount);
            transactionHistory += transaction;
            System.out.printf("You have withdrawn %.2f\n", amount);
            System.out.printf("Your current balance is %.2f\n", balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.println("Please enter the amount to deposit:");
        double amount = scanner.nextDouble();
        balance += amount;
        String transaction = String.format("%s of %.2f deposited\n", TRANSACTIONS[0], amount);
        transactionHistory += transaction;
        System.out.printf("You have deposited %.2f\n", amount);
        System.out.printf("Your current balance is %.2f\n", balance);
    }

    private static void transfer(Scanner scanner) {
        System.out.println("Please enter the recipient's account number:");
        String recipient = scanner.next();
        System.out.println("Please enter the amount to transfer:");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            String transaction = String.format("%s of %.2f transferred to account %s\n", TRANSACTIONS[2], amount, recipient);
            transactionHistory += transaction;
            System.out.printf("You have transferred %.2f to account %s\n", amount, recipient);
            System.out.printf("Your current balance is %.2f\n", balance);
        } else 
        {
            System.out.println("Insufficient funds.");
        }
    }
}

/*

Sample input output:
Welcome to the ATM
Please enter your user id: 
user123
Please enter your user pin: 1234
Login successful.

Select an option:
1. View transaction history
2. Withdraw
3. Deposit
4. Transfer
5. Quit
2
Please enter the amount to withdraw:
500
You have withdrawn 500.00Your current balance is 500.00Select an option:1. View transaction history2. Withdraw3. Deposit4. Transfer
5. Quit
3
Please enter the amount to deposit:1000
You have deposited 1000.00
Your current balance is 1500.00

Select an option:
1. View transaction history
2. Withdraw
3. Deposit
4. Transfer
5. Quit
4
Please enter the recipient's account number:
user456
Please enter the amount to transfer:
800
You have transferred 800.00to account user456Your current balance is 700.00

Select an option:
1. View transaction history
2. Withdraw
3. Deposit
4. Transfer
5. Quit
1
Transaction history:Withdrawal of 500.00 withdrawn
Deposit of 1000.00 deposited
Transfer of 800.00 transferred to account user456


Select an option:1. View transaction history
2. Withdraw
3. Deposit
4. Transfer
5. Quit
5
Thank you for using the ATM. Goodbye!

*/