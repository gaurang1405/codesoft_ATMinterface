import java.util.Scanner;

public class ATMInterface {
    private double balance;

    // Constructor
    public ATMInterface(double startingBalance) {
        balance = startingBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " has been added to your account.");
        } else {
            System.out.println("Please enter a valid amount to deposit.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("₹" + amount + " has been withdrawn from your account.");
            } else {
                System.out.println("You don't have enough balance to withdraw ₹" + amount);
            }
        } else {
            System.out.println("Please enter a valid amount to withdraw.");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }

    // Main ATM Menu
    public void runATM() {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("Welcome to the Simple ATM Machine\n");

        do {
            System.out.println("Please choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Your choice: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your current balance is:₹" + getBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit:₹");
                    double depositAmt = input.nextDouble();
                    deposit(depositAmt);
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw:₹");
                    double withdrawAmt = input.nextDouble();
                    withdraw(withdrawAmt);
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM. Have a great day!");
                    break;

                default:
                    System.out.println("Oops! That's not a valid option. Try again.");
            }

            System.out.println();

        } while (option != 4);

        input.close();
    }

    // Main method
    public static void main(String[] args) {
        ATMInterface myATM = new ATMInterface(5000.0);
        myATM.runATM();
    }
}