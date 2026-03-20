import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(350, 400);
        frame.setLayout(null);

        JTextField display = new JTextField();
        display.setBounds(50, 50, 230, 40);
        frame.add(display);

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");

        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");
        JButton eq = new JButton("=");

        JButton clear = new JButton("C");

        JButton[] buttons = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b0};

        int x = 50, y = 100;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(x, y, 50, 40);
            frame.add(buttons[i]);
            x += 60;

            if ((i + 1) % 3 == 0) {
                x = 50;
                y += 50;
            }
        }

        add.setBounds(200, 100, 50, 40);
        sub.setBounds(200, 150, 50, 40);
        mul.setBounds(200, 200, 50, 40);
        div.setBounds(200, 250, 50, 40);
        eq.setBounds(50, 300, 100, 40);
        clear.setBounds(160, 300, 100, 40);

        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(eq);
        frame.add(clear);

        String[] operator = {""};
        int[] num1 = {0};

        // Number buttons
        for (JButton btn : buttons) {
            btn.addActionListener(e -> {
                display.setText(display.getText() + btn.getText());
            });
        }

        // Operator buttons
        add.addActionListener(e -> {
            num1[0] = Integer.parseInt(display.getText());
            operator[0] = "+";
            display.setText("");
        });

        sub.addActionListener(e -> {
            num1[0] = Integer.parseInt(display.getText());
            operator[0] = "-";
            display.setText("");
        });

        mul.addActionListener(e -> {
            num1[0] = Integer.parseInt(display.getText());
            operator[0] = "*";
            display.setText("");
        });

        div.addActionListener(e -> {
            num1[0] = Integer.parseInt(display.getText());
            operator[0] = "/";
            display.setText("");
        });

        // Equal button
        eq.addActionListener(e -> {
            int num2 = Integer.parseInt(display.getText());
            int result = 0;

            switch (operator[0]) {
                case "+": result = num1[0] + num2; break;
                case "-": result = num1[0] - num2; break;
                case "*": result = num1[0] * num2; break;
                case "/": result = num1[0] / num2; break;
            }

            display.setText(String.valueOf(result));
        });

        // Clear button
        clear.addActionListener(e -> {
            display.setText("");
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
