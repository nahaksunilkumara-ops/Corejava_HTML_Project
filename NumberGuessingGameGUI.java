import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGameGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel title = new JLabel("Guess a Number (1-100)");
        title.setBounds(100, 20, 200, 30);
        frame.add(title);

        JTextField inputField = new JTextField();
        inputField.setBounds(100, 70, 150, 30);
        frame.add(inputField);

        JButton guessBtn = new JButton("Guess");
        guessBtn.setBounds(100, 110, 150, 30);
        frame.add(guessBtn);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(100, 150, 250, 30);
        frame.add(resultLabel);

        JLabel attemptsLabel = new JLabel("Attempts: 0");
        attemptsLabel.setBounds(100, 180, 200, 30);
        frame.add(attemptsLabel);

        Random rand = new Random();
        int target = rand.nextInt(100) + 1;

        int[] attempts = {0};

        guessBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int guess = Integer.parseInt(inputField.getText());
                    attempts[0]++;

                    if (guess == target) {
                        resultLabel.setText("Correct! You Win 🎉");
                        guessBtn.setEnabled(false);
                    } else if (guess < target) {
                        resultLabel.setText("Too Low!");
                    } else {
                        resultLabel.setText("Too High!");
                    }

                    attemptsLabel.setText("Attempts: " + attempts[0]);

                } catch (Exception ex) {
                    resultLabel.setText("Enter valid number!");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
