package personal.tejaunrichard;


import java.sql.SQLOutput;
import java.util.Scanner;

public class BankAccount {

    double balance;
    double previousTransaction;
    String customerName;
    String customerID;

    BankAccount(String cName, String cIdentification) {
        customerName = cName;
        customerID = cIdentification;
    }

    void deposit(double amount) {

        if (amount > 0) {         // If the amount is greater than 0
            balance += amount;     // Set the balance equal to the original balance + new amount
            previousTransaction = amount;   // Set previous transaction to the
        }

    }

    void withdraw(double amount) {

        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {

        if (previousTransaction > 0) {
            System.out.println("Your last transaction was a deposit of " + previousTransaction + ".");
        } else if (previousTransaction < 0) {
            System.out.println("Your last transaction was a withdrawal of " + Math.abs(previousTransaction) + ".");
        } else {
            System.out.println("No transaction has occurred.");
        }
    }

    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, " + customerName + "! Welcome to Piglet Bank.");
        System.out.println("Your ID is " + customerID + ".");
        System.out.println("\n");
        System.out.println("How can we help you today?");

        System.out.println("A. Check Balance");
        System.out.println("B. Make a Deposit");
        System.out.println("C. Make a Withdrawal");
        System.out.println("D. See Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("------------------------------------------------------------");
            System.out.println("Please enter an option.");
            System.out.println("------------------------------------------------------------");
            option = scanner.next().charAt(0);
            System.out.println("\n");  // Just a line break.

            switch (option) {
                case 'A':  // Check Balance
                    System.out.println("----------------------------------------");
                    System.out.println("Your current balance is " + balance + ".");
                    System.out.println("----------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':  // Make a Deposit
                    System.out.println("----------------------------------------");
                    System.out.println("Please enter the amount you'd like to deposit.");
                    System.out.println("----------------------------------------");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;

                case 'C':  // Make a Withdrawal
                    System.out.println("----------------------------------------");
                    System.out.println("Please enter the amount you'd like to withdraw.");
                    System.out.println("----------------------------------------");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("----------------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------------");
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Sorry, that's not a valid option. Please try again.");
                    break;

                case 'E':
                    System.out.println("----------------------------------------");
                    System.out.println("----------------------------------------");
                    break;
            }

        } while (option != 'E');

        System.out.println("Thank you for banking with Piglet! We look forward to seeing you again.");
    }
}
