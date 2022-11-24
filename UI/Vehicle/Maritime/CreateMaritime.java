package Vehicle.Maritime;
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
import Database.Vehicle.MaritimeDatabase;
import Database.Vehicle.ShipDatabase;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CreateMaritime extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        try {
            CreateMaritime frame = new CreateMaritime();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreateMaritime(){
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("Veículos Marítimos");
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

        String[] vehicleOptions = {"Lancha", "Navio"};
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
        widthLabel.setBounds(23, 297, 65, 19);
        contentPane.add(widthLabel);

        JTextField widthField = new JTextField();
        widthField.setFont(new Font("Arial", Font.PLAIN, 13));
        widthField.setBounds(38, 319, 165, 25);
        widthField.setColumns(10);
        contentPane.add(widthField);

        JButton chooseButton = new JButton("Escolher");
        chooseButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        chooseButton.setFont(new Font("Arial", Font.BOLD, 12));
        chooseButton.setBounds(220, 59, 100, 25);
        contentPane.add(chooseButton);

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

        JLabel loadLabel = new JLabel("Peso da Carga");
        loadLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadLabel.setForeground(Color.BLACK);
        loadLabel.setBounds(38, 410, 90, 19);
        loadLabel.setVisible(false);
        contentPane.add(loadLabel);

        JTextField loadField = new JTextField();
        loadField.setFont(new Font("Arial", Font.PLAIN, 13));
        loadField.setBounds(38, 430, 165, 25);
        loadField.setColumns(10);
        loadField.setVisible(false);
        contentPane.add(loadField);
        


        JButton submitButton = new JButton("Cadastrar");
        submitButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setBounds(77, 410, 80, 25);
        contentPane.add(submitButton);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (vehicleBox.getSelectedItem().equals("Navio")) {
                    loadLabel.setVisible(true);
                    loadField.setVisible(true);
                    submitButton.setBounds(77, 470, 80, 25);
                } else {
                    loadLabel.setVisible(false);
                    loadField.setVisible(false);
                    submitButton.setBounds(77, 420, 80, 25);
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
                    Double velocity =  Double.parseDouble(widthField.getText());
                    Database database = new MaritimeDatabase();
                    Maritime vehicle = new Maritime(code, name, color, height, width, velocity);

                    if (vehicleType.equals("Navio")) {
                        Double load = Double.parseDouble(loadField.getText());
                        vehicle = new Ship(code, name, color, height, width, velocity, load);
                        database = new ShipDatabase();
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

                    if(loadField.isVisible() && loadField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Preencha a quantidade de propulsores, ou mude o tipo de veiculo", "Cadastrado",
                        JOptionPane.ERROR_MESSAGE);
                    }
                    if(loadField.isVisible()){
                        loadField.setText("");
                    }
                } catch (Exception e) {
                    System.out.println("Um erro ocorreu");
                }
            }
        });
    }
}
