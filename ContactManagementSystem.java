import java.util.ArrayList;
import java.util.Scanner;

// Contact class
class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    void display() {
        System.out.println("Name: " + name + " | Phone: " + phone);
    }
}

// Main class
public class ContactManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact Added!");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found!");
                    } else {
                        for (Contact c : contacts) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;

                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(searchName)) {
                            c.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Contact not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Name to delete: ");
                    String deleteName = sc.nextLine();

                    boolean removed = contacts.removeIf(c -> c.name.equalsIgnoreCase(deleteName));

                    if (removed) {
                        System.out.println("Contact Deleted!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
