package Rent;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Database.Person.EmployeeDatabase;
import Database.Vehicle.VehicleDatabase;
import Database.RentDatabase;
import Database.Person.ClientDatabase;
import Vehicle.Vehicle;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.Vector;

public class CreateRent extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        try {
            CreateRent frame = new CreateRent();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreateRent() throws ParseException, IOException {

        ClientDatabase clientDatabase = new ClientDatabase();
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        // VehicleDatabase vehicleDatabase = new VehicleDatabase();

        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("ALUGUEL");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel clientLabel = new JLabel("Cliente");
        clientLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clientLabel.setForeground(Color.BLACK);
        clientLabel.setBounds(20, 37, 65, 19);
        contentPane.add(clientLabel);

        JComboBox clientsCPF = new JComboBox(new Vector<String>(clientDatabase.clientCPFS()));
        clientsCPF.setFont(new Font("Arial", Font.BOLD, 13));
        clientsCPF.setBounds(32, 57, 239, 26);
        contentPane.add(clientsCPF);
        clientsCPF.setForeground(Color.BLACK);
        clientsCPF.setBackground(Color.WHITE);

        JLabel employeeLabel = new JLabel("Funcionário");
        employeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        employeeLabel.setForeground(Color.BLACK);
        employeeLabel.setBounds(295, 37, 82, 19);
        contentPane.add(employeeLabel);

        JComboBox employeeCPF = new JComboBox(new Vector<String>(employeeDatabase.employeeCPFS()));
        employeeCPF.setFont(new Font("Arial", Font.BOLD, 13));
        employeeCPF.setBounds(300, 57, 239, 26);
        contentPane.add(employeeCPF);
        employeeCPF.setForeground(Color.BLACK);
        employeeCPF.setBackground(Color.WHITE);

        JLabel vehicleLabel = new JLabel("Veículo");
        vehicleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        vehicleLabel.setForeground(Color.BLACK);
        vehicleLabel.setBounds(20, 107, 65, 19);
        contentPane.add(vehicleLabel);

        VehicleDatabase vehicleDatabase = new VehicleDatabase();
        
        JComboBox vehicles = new JComboBox(new Vector<String>(vehicleDatabase.vehicleName(vehicleDatabase.getAllVehicle())));
        vehicles.setFont(new Font("Arial", Font.BOLD, 13));
        vehicles.setBounds(32, 127, 239, 26);
        contentPane.add(vehicles);
        vehicles.setForeground(Color.BLACK);
        vehicles.setBackground(Color.WHITE);

        JComboBox vehiclesInterCity = new JComboBox(new Vector<String>(vehicleDatabase.vehicleName(vehicleDatabase.intercityVehicles())));
        vehiclesInterCity.setFont(new Font("Arial", Font.BOLD, 13));
        vehiclesInterCity.setBounds(32, 127, 239, 26);
        contentPane.add(vehiclesInterCity);
        vehiclesInterCity.setVisible(false);
        vehiclesInterCity.setForeground(Color.BLACK);
        vehiclesInterCity.setBackground(Color.WHITE);

        JComboBox vehiclesInterState = new JComboBox(new Vector<String>(vehicleDatabase.vehicleName(vehicleDatabase.interStateVehicles())));
        vehiclesInterState.setFont(new Font("Arial", Font.BOLD, 13));
        vehiclesInterState.setBounds(32, 127, 239, 26);
        contentPane.add(vehiclesInterState);
        vehiclesInterState.setVisible(false);
        vehiclesInterState.setForeground(Color.BLACK);
        vehiclesInterState.setBackground(Color.WHITE);

        JComboBox vehicleInternational = new JComboBox(new Vector<String>(vehicleDatabase.vehicleName(vehicleDatabase.internationalVehicles())));
        vehicleInternational.setFont(new Font("Arial", Font.BOLD, 13));
        vehicleInternational.setBounds(32, 127, 239, 26);
        contentPane.add(vehicleInternational);
        vehicleInternational.setVisible(false);
        vehicleInternational.setForeground(Color.BLACK);
        vehicleInternational.setBackground(Color.WHITE);

        JLabel pagamentoLabel = new JLabel("Pagamento");
        pagamentoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pagamentoLabel.setForeground(Color.BLACK);
        pagamentoLabel.setBounds(295, 107, 82, 19);
        contentPane.add(pagamentoLabel);

        
        JLabel valueLabel = new JLabel("Valor");
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setForeground(Color.BLACK);
        valueLabel.setBounds(550, 107, 82, 19);
        contentPane.add(valueLabel);

        JTextField valueField = new JTextField();
        valueField.setFont(new Font("Arial", Font.PLAIN, 13));
        valueField.setBounds(575, 127, 165, 25);
        valueField.setColumns(10);
        contentPane.add(valueField);

        String[] paymentMethods = { "Débito", "Crédito", "Dinheiro", "Pix"};
        JComboBox pagamento = new JComboBox(paymentMethods);
        pagamento.setFont(new Font("Arial", Font.BOLD, 13));
        pagamento.setBounds(300, 127, 239, 26);
        contentPane.add(pagamento);
        pagamento.setForeground(Color.BLACK);
        pagamento.setBackground(Color.WHITE);

        JLabel travelLabel = new JLabel("Viagem");
        travelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        travelLabel.setForeground(Color.BLACK);
        travelLabel.setBounds(15, 160, 82, 19);
        contentPane.add(travelLabel); 

        JRadioButton r1 = new JRadioButton("Sim");    
        r1.setBounds(32,180,50,20);
        contentPane.add(r1);
           
        JRadioButton r2 = new JRadioButton("Não");    
        r2.setBounds(80,180,50,20);
        contentPane.add(r2);

        JLabel travelOptionsLabel = new JLabel("Opções de viagem");
        travelOptionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        travelOptionsLabel.setForeground(Color.BLACK);
        travelOptionsLabel.setBounds(15, 210, 150, 19);
        travelOptionsLabel.setVisible(false);
        contentPane.add(travelOptionsLabel); 

        JRadioButton r3 = new JRadioButton("Intermunicipal");    
        r3.setBounds(32,230,110,20);
        r3.setVisible(false);
        contentPane.add(r3);
           
        JRadioButton r4 = new JRadioButton("Interestadual");    
        r4.setBounds(150,230,100,20);
        r4.setVisible(false);
        contentPane.add(r4);

        JRadioButton r5 = new JRadioButton("Internacional");    
        r5.setBounds(260,230,100,20);
        r5.setVisible(false);
        contentPane.add(r5);

        r1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                travelOptionsLabel.setVisible(true);
                r3.setVisible(true);
                r4.setVisible(true);
                r5.setVisible(true);
                r2.setSelected(false);
            }
        });

        r2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                travelOptionsLabel.setVisible(false);
                r3.setVisible(false);
                r4.setVisible(false);
                r5.setVisible(false);
                r1.setSelected(false);
            }
        });
        
        r3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            vehicles.setVisible(false);
            vehiclesInterState.setVisible(false);
            vehicleInternational.setVisible(false);
            vehiclesInterCity.setVisible(true);
            r4.setSelected(false);
            r5.setSelected(false);
            }
        });

        r4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicles.setVisible(false);
                vehiclesInterState.setVisible(true);
                vehicleInternational.setVisible(false);
                vehiclesInterCity.setVisible(false);
                r3.setSelected(false);
                r5.setSelected(false);
            }
        });

        r5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicles.setVisible(false);
                vehiclesInterState.setVisible(false);
                vehicleInternational.setVisible(true);
                vehiclesInterCity.setVisible(false);
                r3.setSelected(false);
                r4.setSelected(false);
            }
        });


        JButton submitButton = new JButton("Confirmar");
        submitButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setBounds(245, 200, 80, 25);
        contentPane.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String veiculo = "";
                if (r3.isSelected()) {
                    veiculo = (String)vehiclesInterCity.getSelectedItem(); 
                }
                if (r4.isSelected()) {
                    veiculo = (String)vehiclesInterState.getSelectedItem(); 
                }
                if (r3.isSelected()) {
                    veiculo = (String)vehicleInternational.getSelectedItem(); 
                }
                String clientCPF = (String) clientsCPF.getSelectedItem();
                String paymentMethod = (String)pagamento.getSelectedItem();                
                String employeeString = (String) employeeCPF.getSelectedItem();
                Double valueDouble = Double.parseDouble(valueField.getText());
                Rent rent = new Rent(veiculo, clientCPF, employeeString, paymentMethod, valueDouble);
                RentDatabase rentDatabase = new RentDatabase();
                
                try {
                    rentDatabase.add(rent.toString());
                    JOptionPane.showMessageDialog(null, "Aluguel cadastrado com sucesso", "Cadastrado",
                    JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}

