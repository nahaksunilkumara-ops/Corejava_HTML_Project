import javax.swing.*;
import java.awt.event.*;

public class QuizGameGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Quiz Game");
        frame.setSize(500, 400);
        frame.setLayout(null);

        JLabel questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 400, 30);
        frame.add(questionLabel);

        JButton option1 = new JButton();
        option1.setBounds(50, 100, 200, 30);
        frame.add(option1);

        JButton option2 = new JButton();
        option2.setBounds(50, 140, 200, 30);
        frame.add(option2);

        JButton option3 = new JButton();
        option3.setBounds(50, 180, 200, 30);
        frame.add(option3);

        JButton option4 = new JButton();
        option4.setBounds(50, 220, 200, 30);
        frame.add(option4);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(50, 280, 400, 30);
        frame.add(resultLabel);

        String[] questions = {
            "1. Capital of India?",
            "2. 2 + 2 = ?",
            "3. Java is a ___?"
        };

        String[][] options = {
            {"Delhi", "Mumbai", "Kolkata", "Chennai"},
            {"3", "4", "5", "6"},
            {"Language", "Fruit", "Car", "Animal"}
        };

        int[] answers = {0, 1, 0}; // correct option index
        int[] index = {0};
        int[] score = {0};

        // Load Question
        Runnable loadQuestion = () -> {
            if (index[0] < questions.length) {
                questionLabel.setText(questions[index[0]]);
                option1.setText(options[index[0]][0]);
                option2.setText(options[index[0]][1]);
                option3.setText(options[index[0]][2]);
                option4.setText(options[index[0]][3]);
            } else {
                questionLabel.setText("Quiz Finished!");
                resultLabel.setText("Score: " + score[0] + "/" + questions.length);
                option1.setVisible(false);
                option2.setVisible(false);
                option3.setVisible(false);
                option4.setVisible(false);
            }
        };

        loadQuestion.run();

        // Button Actions
        ActionListener checkAnswer = e -> {
            JButton btn = (JButton) e.getSource();
            int selected = 0;

            if (btn == option1) selected = 0;
            else if (btn == option2) selected = 1;
            else if (btn == option3) selected = 2;
            else if (btn == option4) selected = 3;

            if (selected == answers[index[0]]) {
                score[0]++;
            }

            index[0]++;
            loadQuestion.run();
        };

        option1.addActionListener(checkAnswer);
