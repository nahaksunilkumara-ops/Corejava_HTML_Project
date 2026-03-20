import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagementSwing {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 50, 100, 30);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 50, 150, 30);
        frame.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 150, 30);
        frame.add(nameField);

        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(50, 150, 100, 30);
        frame.add(marksLabel);

        JTextField marksField = new JTextField();
        marksField.setBounds(150, 150, 150, 30);
        frame.add(marksField);

        JButton addBtn = new JButton("Add Student");
        addBtn.setBounds(100, 200, 150, 30);
        frame.add(addBtn);

        JTextArea output = new JTextArea();
        output.setBounds(50, 250, 300, 100);
        frame.add(output);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int marks = Integer.parseInt(marksField.getText());

                list.add(new Student(id, name, marks));

                output.setText("Student Added!\n");
                output.append("Total Students: " + list.size());
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
