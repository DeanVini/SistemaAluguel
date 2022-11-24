package Employee;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Database.Person.EmployeeDatabase;
import Person.Employee;

import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchEmployee extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        try {
            SearchEmployee frame = new SearchEmployee();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SearchEmployee() throws ParseException, IOException{
        MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");// MASCARA DE CPF
        
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("LISTA DE FUNCIONÁRIOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Nome");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(23, 70, 65, 19);
        contentPane.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 13));
        nameField.setBounds(38, 90, 165, 25);
        nameField.setColumns(10);
        contentPane.add(nameField);

        JLabel ageLabel = new JLabel("Idade");
        ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ageLabel.setForeground(Color.BLACK);
        ageLabel.setBounds(23, 120, 65, 19);
        contentPane.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 13));
        ageField.setBounds(38, 140, 165, 25);
        ageField.setColumns(10);
        contentPane.add(ageField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(23, 170, 65, 19);
        contentPane.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 13));
        emailField.setBounds(38, 190, 165, 25);
        emailField.setColumns(10);
        contentPane.add(emailField);

        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpfLabel.setForeground(Color.BLACK);
        cpfLabel.setBounds(19, 220, 65, 19);
        contentPane.add(cpfLabel);

        JFormattedTextField cpfField = new JFormattedTextField(cpfMask);
        cpfField.setFont(new Font("Arial", Font.PLAIN, 13));
        cpfField.setBounds(38, 240, 165, 25);
        cpfField.setColumns(10);
        contentPane.add(cpfField);

        JLabel roleLabel = new JLabel("Cargo");
        roleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        roleLabel.setForeground(Color.BLACK);
        roleLabel.setBounds(25, 270, 65, 19);
        contentPane.add(roleLabel);

        JTextField roleField = new JTextField();
        roleField.setFont(new Font("Arial", Font.PLAIN, 13));
        roleField.setBounds(38, 290, 165, 25);
        roleField.setColumns(10);
        contentPane.add(roleField);
        
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        
        JComboBox clientsCPF = new JComboBox(new Vector<String>(employeeDatabase.employeeCPFS()));
        clientsCPF.setFont(new Font("Arial", Font.BOLD, 13));
        clientsCPF.setBounds(35, 40, 239, 26);
        contentPane.add(clientsCPF);
        clientsCPF.setForeground(Color.BLACK);
        clientsCPF.setBackground(Color.WHITE);

        JButton buttonSearch = new JButton("Buscar");
        buttonSearch.setFont(new Font("Arial", Font.BOLD, 13));
        buttonSearch.setBounds(350, 40, 130, 26);
        contentPane.add(buttonSearch);

        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CPF = (String) clientsCPF.getSelectedItem();
                EmployeeDatabase employeeDatabase = new EmployeeDatabase();
                try {
                    Employee employee = employeeDatabase.getByCPF(CPF);
                    if (employee != null) {
                        nameField.setText(employee.getName());
                        ageField.setText(Integer.toString(employee.getAge()));
                        emailField.setText(employee.getEmail());
                        cpfField.setText(employee.getCPF());
                        roleField.setText(employee.getRole());
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
