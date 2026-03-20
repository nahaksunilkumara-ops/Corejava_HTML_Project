import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class Book {
    String name;

    Book(String name) {
        this.name = name;
    }
}

public class LibraryGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Library Management System");
        frame.setSize(450, 400);
        frame.setLayout(null);

        JLabel title = new JLabel("LIBRARY SYSTEM");
        title.setBounds(150, 20, 200, 30);
        frame.add(title);

        JLabel bookLabel = new JLabel("Enter Book Name:");
        bookLabel.setBounds(50, 80, 150, 30);
        frame.add(bookLabel);

        JTextField bookField = new JTextField();
        bookField.setBounds(180, 80, 180, 30);
        frame.add(bookField);

        JTextArea output = new JTextArea();
        output.setBounds(50, 250, 320, 80);
        frame.add(output);

        JButton addBtn = new JButton("Add Book");
        addBtn.setBounds(50, 130, 120, 30);
        frame.add(addBtn);

        JButton viewBtn = new JButton("View Books");
        viewBtn.setBounds(200, 130, 150, 30);
        frame.add(viewBtn);

        ArrayList<Book> books = new ArrayList<>();

        // Add Book
        addBtn.addActionListener(e -> {
            String name = bookField.getText();

            if (!name.isEmpty()) {
                books.add(new Book(name));
                output.setText("Book Added: " + name);
                bookField.setText("");
            } else {
                output.setText("Enter book name!");
            }
        });

        // View Books
        viewBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            for (Book b : books) {
                sb.append(b.name).append("\n");
            }

            output.setText(sb.toString());
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
