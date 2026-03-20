import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account No: " + accNo + " | Name: " + name + " | Balance: " + balance);
    }
}

// Main class
public class BankManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n==== Bank Management System ====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Search Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    accounts.add(new Account(accNo, name, balance));
                    System.out.println("Account Created Successfully!");
                    break;

                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found!");
                    } else {
                        for (Account acc : accounts) {
                            acc.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();

                    boolean foundDep = false;

                    for (Account acc : accounts) {
                        if (acc.accNo == depAcc) {
                            System.out.print("Enter amount to deposit: ");
                            double amt = sc.nextDouble();
                            acc.balance += amt;
                            System.out.println("Deposit Successful!");
                            foundDep = true;
                            break;
                        }
                    }

                    if (!foundDep) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();

                    boolean foundWith = false;

                    for (Account acc : accounts) {
                        if (acc.accNo == withAcc) {
                            System.out.print("Enter amount to withdraw: ");
                            double amt = sc.nextDouble();

                            if (amt > acc.balance) {
                                System.out.println("Insufficient Balance!");
                            } else {
                                acc.balance -= amt;
                                System.out.println("Withdrawal Successful!");
                            }

                            foundWith = true;
                            break;
                        }
                    }

                    if (!foundWith) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number to search: ");
                    int searchAcc = sc.nextInt();

                    boolean foundSearch = false;

                    for (Account acc : accounts) {
                        if (acc.accNo == searchAcc) {
                            acc.display();
                            foundSearch = true;
                            break;
                        }
                    }

                    if (!foundSearch) {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}
