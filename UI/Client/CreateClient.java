package Client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Client.Validations.AgeValidator;
import Client.Validations.CPFValidator;
import Client.Validations.EmailValidator;
import Client.Validations.NameValidator;
import Database.Person.ClientDatabase;
import Person.Client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class CreateClient extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        try {
            CreateClient frame = new CreateClient();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreateClient() throws ParseException {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("CADASTRO DE CLIENTES");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);

        MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");// MASCARA DE CPF

        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Nome");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(23, 37, 65, 19);
        contentPane.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 13));
        nameField.setBounds(38, 59, 165, 25);
        nameField.setColumns(10);
        contentPane.add(nameField);

        JLabel ageLabel = new JLabel("Idade");
        ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ageLabel.setForeground(Color.BLACK);
        ageLabel.setBounds(23, 89, 65, 19);
        contentPane.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setFont(new Font("Arial", Font.PLAIN, 13));
        ageField.setBounds(38, 111, 165, 25);
        ageField.setColumns(10);
        contentPane.add(ageField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(23, 141, 65, 19);
        contentPane.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 13));
        emailField.setBounds(38, 163, 165, 25);
        emailField.setColumns(10);
        contentPane.add(emailField);

        JLabel cpfLabel = new JLabel("CPF");
        cpfLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpfLabel.setForeground(Color.BLACK);
        cpfLabel.setBounds(19, 193, 65, 19);
        contentPane.add(cpfLabel);

        JFormattedTextField cpfField = new JFormattedTextField(cpfMask);
        cpfField.setFont(new Font("Arial", Font.PLAIN, 13));
        cpfField.setBounds(38, 215, 165, 25);
        cpfField.setColumns(10);
        contentPane.add(cpfField);

        JLabel licenseLabel = new JLabel("Carteira de Habilitação");
        licenseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        licenseLabel.setForeground(Color.BLACK);
        licenseLabel.setBounds(25, 245, 150, 19);
        contentPane.add(licenseLabel);

        String[] licenseOptions = { "A", "B", "C", "D", "E" };
        JComboBox licenseBox = new JComboBox(licenseOptions);
        licenseBox.setFont(new Font("Arial", Font.PLAIN, 13));
        licenseBox.setBounds(37, 267, 165, 25);
        licenseBox.setForeground(Color.BLACK);
        licenseBox.setBackground(Color.WHITE);
        contentPane.add(licenseBox);

        JButton submitButton = new JButton("Cadastrar");
        submitButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setBounds(77, 305, 80, 25);
        contentPane.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NameValidator nameValidator = new NameValidator();
                CPFValidator cpfValidator = new CPFValidator();
                AgeValidator ageValidator = new AgeValidator();
                EmailValidator emailValidator = new EmailValidator();
                
                boolean nameIsValid = nameValidator.validate(nameField);
                boolean ageIsValid = ageValidator.validate(ageField);
                boolean cpfIsValid = cpfValidator.validate(cpfField);
                boolean emailValid = emailValidator.validate(emailField);
                
                boolean clientValidated = nameIsValid && ageIsValid && cpfIsValid && emailValid;

                if (clientValidated) {
                    String name = nameField.getText();
                    Integer age = Integer.parseInt(ageField.getText());
                    String email = emailField.getText();
                    String cpf = cpfField.getText();
                    String license = (String)licenseBox.getSelectedItem();
    
                    Client client = new Client(name, age, email, cpf, license);
        
                    ClientDatabase database = new ClientDatabase();
                    try {
                        database.add(client.toString());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    nameField.setText("");
                    ageField.setText("");
                    emailField.setText("");
                    cpfField.setText("");
                    JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso", "Cadastrado", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}
