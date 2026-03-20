import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactManagementGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Contact Management System");
        frame.setSize(450, 400);
        frame.setLayout(null);

        JLabel title = new JLabel("CONTACT MANAGER");
        title.setBounds(140, 20, 200, 30);
        frame.add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 80, 200, 30);
        frame.add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 120, 100, 30);
        frame.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 120, 200, 30);
        frame.add(phoneField);

        JTextArea output = new JTextArea();
        output.setBounds(50, 250, 320, 80);
        frame.add(output);

        JButton addBtn = new JButton("Add Contact");
        addBtn.setBounds(50, 170, 130, 30);
        frame.add(addBtn);

        JButton viewBtn = new JButton("View Contacts");
        viewBtn.setBounds(200, 170, 150, 30);
        frame.add(viewBtn);

        ArrayList<Contact> contacts = new ArrayList<>();

        // Add Contact
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();

            if (!name.isEmpty() && !phone.isEmpty()) {
                contacts.add(new Contact(name, phone));
                output.setText("Contact Added:\n" + name + " - " + phone);
                nameField.setText("");
                phoneField.setText("");
            } else {
                output.setText("Please enter all details!");
            }
        });

        // View Contacts
        viewBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            for (Contact c : contacts) {
                sb.append(c.name).append(" - ").append(c.phone).append("\n");
            }

            output.setText(sb.toString());
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
