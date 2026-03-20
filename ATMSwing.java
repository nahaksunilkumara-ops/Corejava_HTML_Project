import javax.swing.*;
import java.awt.event.*;

public class ATMSwing {

    public static void main(String[] args) {

        JFrame frame = new JFrame("ATM Machine");
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel title = new JLabel("ATM SYSTEM");
        title.setBounds(150, 20, 100, 30);
        frame.add(title);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(50, 80, 120, 30);
        frame.add(amountLabel);

        JTextField amountField = new JTextField();
        amountField.setBounds(180, 80, 150, 30);
        frame.add(amountField);

        JTextArea output = new JTextArea();
        output.setBounds(50, 250, 280, 80);
        frame.add(output);

        JButton balanceBtn = new JButton("Check Balance");
        balanceBtn.setBounds(50, 130, 150, 30);
        frame.add(balanceBtn);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 170, 150, 30);
        frame.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(210, 170, 150, 30);
        frame.add(withdrawBtn);

        int[] balance = {1000};

        // Check Balance
        balanceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("Balance: " + balance[0]);
            }
        });

        // Deposit
        depositBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());
                balance[0] += amount;
                output.setText("Deposited: " + amount + "\nBalance: " + balance[0]);
            }
        });

        // Withdraw
        withdrawBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());

                if (amount <= balance[0]) {
                    balance[0] -= amount;
                    output.setText("Withdraw: " + amount + "\nBalance: " + balance[0]);
                } else {
                    output.setText("Insufficient Balance!");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
