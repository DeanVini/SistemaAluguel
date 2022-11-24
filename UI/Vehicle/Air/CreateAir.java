package Vehicle.Air;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Database.Database;
import Database.Vehicle.AirDatabase;
import Database.Vehicle.HelicopterDatabase;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CreateAir extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        try {
            CreateAir frame = new CreateAir();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreateAir() {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("Veículos Aérios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel vehicleLabel = new JLabel("Veículo:");
        vehicleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        vehicleLabel.setForeground(Color.BLACK);
        vehicleLabel.setBounds(25, 37, 150, 19);
        contentPane.add(vehicleLabel);

        String[] vehicleOptions = { "Helicóptero", "Jato", "Avião" };
        JComboBox vehicleBox = new JComboBox(vehicleOptions);
        vehicleBox.setFont(new Font("Arial", Font.PLAIN, 13));
        vehicleBox.setBounds(37, 59, 165, 25);
        vehicleBox.setForeground(Color.BLACK);
        vehicleBox.setBackground(Color.WHITE);
        contentPane.add(vehicleBox);

        JLabel nameLabel = new JLabel("Nome");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(23, 89, 65, 19);
        contentPane.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 13));
        nameField.setBounds(38, 111, 165, 25);
        nameField.setColumns(10);
        contentPane.add(nameField);

        JLabel codeLabel = new JLabel("Chassi");
        codeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        codeLabel.setForeground(Color.BLACK);
        codeLabel.setBounds(23, 141, 65, 19);
        contentPane.add(codeLabel);

        JTextField codeField = new JTextField();
        codeField.setFont(new Font("Arial", Font.PLAIN, 13));
        codeField.setBounds(38, 163, 165, 25);
        codeField.setColumns(10);
        contentPane.add(codeField);

        JLabel colorLabel = new JLabel("Cor");
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        colorLabel.setForeground(Color.BLACK);
        colorLabel.setBounds(23, 193, 65, 19);
        contentPane.add(colorLabel);

        JTextField colorField = new JTextField();
        colorField.setFont(new Font("Arial", Font.PLAIN, 13));
        colorField.setBounds(38, 215, 165, 25);
        colorField.setColumns(10);
        contentPane.add(colorField);

        JLabel heightLabel = new JLabel("Peso");
        heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        heightLabel.setForeground(Color.BLACK);
        heightLabel.setBounds(23, 245, 65, 19);
        contentPane.add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setFont(new Font("Arial", Font.PLAIN, 13));
        heightField.setBounds(38, 267, 165, 25);
        contentPane.add(heightField);

        JLabel widthLabel = new JLabel("Largura");
        widthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        widthLabel.setForeground(Color.BLACK);
        widthLabel.setBounds(30, 297, 65, 19);
        contentPane.add(widthLabel);

        JTextField widthField = new JTextField();
        widthField.setFont(new Font("Arial", Font.PLAIN, 13));
        widthField.setBounds(38, 319, 165, 25);
        widthField.setColumns(10);
        contentPane.add(widthField);

        JLabel velocityLabel = new JLabel("Velocidade");
        velocityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        velocityLabel.setForeground(Color.BLACK);
        velocityLabel.setBounds(38, 350, 65, 19);
        contentPane.add(velocityLabel);

        JTextField velocityField = new JTextField();
        velocityField.setFont(new Font("Arial", Font.PLAIN, 13));
        velocityField.setBounds(38, 375, 165, 25);
        velocityField.setColumns(10);
        contentPane.add(velocityField);

        JLabel qntdRodas = new JLabel("Quantidade de Rodas");
        qntdRodas.setHorizontalAlignment(SwingConstants.CENTER);
        qntdRodas.setForeground(Color.BLACK);
        qntdRodas.setBounds(23, 405, 150, 19);
        contentPane.add(qntdRodas);

        JTextField qntdRodas2 = new JTextField();
        qntdRodas2.setFont(new Font("Arial", Font.PLAIN, 13));
        qntdRodas2.setBounds(38, 430, 165, 25);
        qntdRodas2.setColumns(10);
        contentPane.add(qntdRodas2);

        JLabel qntProp = new JLabel("Quantidade de Propulsores");
        qntProp.setHorizontalAlignment(SwingConstants.CENTER);
        qntProp.setForeground(Color.BLACK);
        qntProp.setVisible(false);
        qntProp.setBounds(34, 460, 165, 19);
        contentPane.add(qntProp);

        JTextField qntdProp2 = new JTextField();
        qntdProp2.setFont(new Font("Arial", Font.PLAIN, 13));
        qntdProp2.setBounds(38, 485, 165, 25);
        qntdProp2.setColumns(10);
        qntdProp2.setVisible(false);
        contentPane.add(qntdProp2);

        JButton chooseButton = new JButton("Escolher");
        chooseButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        chooseButton.setFont(new Font("Arial", Font.BOLD, 12));
        chooseButton.setBounds(220, 59, 100, 25);
        contentPane.add(chooseButton);

        JButton submitButton = new JButton("Cadastrar");
        submitButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setBounds(77, 470, 80, 25);
        contentPane.add(submitButton);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (vehicleBox.getSelectedItem().equals("Helicóptero")) {
                    qntProp.setVisible(true);
                    qntdProp2.setVisible(true);
                    submitButton.setBounds(77, 520, 80, 25);
                } else {
                    qntProp.setVisible(false);
                    qntdProp2.setVisible(false);
                    submitButton.setBounds(77, 470, 80, 25);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String vehicleType = (String) vehicleBox.getSelectedItem();
                    String name = nameField.getText();
                    String code = codeField.getText();
                    String color = colorField.getText();
                    Double height =  Double.parseDouble(heightField.getText());
                    Double width =  Double.parseDouble(widthField.getText());
                    Double velocity =  Double.parseDouble(velocityField.getText());
                    Integer wheelsQuantity = Integer.parseInt(qntdRodas2.getText());
                    Database database = new AirDatabase();
                    Air vehicle = new Air(code, name, color, height, width, velocity, wheelsQuantity);

                    if (vehicleType.equals("Helicóptero")) {
                        Integer propellersQuantity = Integer.parseInt(qntdProp2.getText());
                        vehicle = new Helicopter(code, name, color, height, width, velocity, wheelsQuantity, propellersQuantity);
                        database = new HelicopterDatabase();
                    }

                    try {
                        database.add(vehicle.toString());
                        JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso", "Cadastrado",
                        JOptionPane.PLAIN_MESSAGE);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    nameField.setText("");
                    codeField.setText("");
                    colorField.setText("");
                    heightField.setText("");
                    widthField.setText("");
                    velocityField.setText("");
                    qntdRodas2.setText("");
                    
                    if(qntdProp2.isVisible() && qntdProp2.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Preencha a quantidade de propulsores, ou mude o tipo de veiculo", "Cadastrado",
                        JOptionPane.ERROR_MESSAGE);
                    }
                    if(qntdProp2.isVisible()){
                        qntdProp2.setText("");
                    }
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}