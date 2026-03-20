import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        // Questions
        String[] questions = {
            "1. What is the capital of India?\n a) Mumbai\n b) Delhi\n c) Kolkata\n d) Chennai",
            "2. Which language is used for Android Development?\n a) Python\n b) Java\n c) C++\n d) HTML",
            "3. Who is known as Father of Computer?\n a) Newton\n b) Charles Babbage\n c) Einstein\n d) Tesla",
            "4. Which is not a programming language?\n a) Java\n b) HTML\n c) Python\n d) C++",
            "5. What is 5 + 3?\n a) 6\n b) 7\n c) 8\n d) 9"
        };

        // Answers
        char[] answers = {'b', 'b', 'b', 'b', 'c'};

        // Quiz loop
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Enter your answer: ");
            char userAns = sc.next().charAt(0);

            if (userAns == answers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }
        }

        // Result
        System.out.println("Your Score: " + score + "/" + questions.length);

        if (score == questions.length) {
            System.out.println("Excellent!");
        } else if (score >= 3) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Try Again!");
        }
    }
}
