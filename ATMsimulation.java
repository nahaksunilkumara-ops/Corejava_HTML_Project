import java.util.Scanner;

class ATM {
    private int balance = 10000; // initial balance
    private int pin = 1234;

    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("Wrong PIN! Access Denied.");
            return;
        }

        int choice;

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        int amount = sc.nextInt();
        balance += amount;
        System.out.println("Amount Deposited Successfully!");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
        }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.start();
    }
}
