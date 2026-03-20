import javax.swing.*;
import java.awt.event.*;

public class BankGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Management System");
        frame.setSize(450, 400);
        frame.setLayout(null);

        JLabel title = new JLabel("BANK SYSTEM");
        title.setBounds(160, 20, 200, 30);
        frame.add(title);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(50, 80, 120, 30);
        frame.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(180, 80, 180, 30);
        frame.add(amountField);

        JTextArea output = new JTextArea();
        output.setBounds(50, 250, 320, 80);
        frame.add(output);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 130, 120, 30);
        frame.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(200, 130, 120, 30);
        frame.add(withdrawBtn);

        JButton balanceBtn = new JButton("Check Balance");
        balanceBtn.setBounds(120, 180, 150, 30);
        frame.add(balanceBtn);

        int[] balance = {3000};

        // Deposit
        depositBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());
                balance[0] += amount;
                output.setText("Deposited: " + amount + "\nBalance: " + balance[0]);
            } catch (Exception ex) {
                output.setText("Invalid Input!");
            }
        });

        // Withdraw
        withdrawBtn.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());

                if (amount <= balance[0]) {
                    balance[0] -= amount;
                    output.setText("Withdraw: " + amount + "\nBalance: " + balance[0]);
                } else {
                    output.setText("Insufficient Balance!");
                }
            } catch (Exception ex) {
                output.setText("Invalid Input!");
            }
        });

        // Balance
        balanceBtn.addActionListener(e -> {
            output.setText("Current Balance: " + balance[0]);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
