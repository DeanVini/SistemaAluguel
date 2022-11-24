import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.HomeClient;
import Employee.HomeEmployee;
import Vehicle.HomeVehicle;
import Rent.HomeRent;


import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {

        try {
            Home frame = new Home();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Home(){
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("Home");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);


        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton buttonClients = new JButton("Clientes");
        buttonClients.setFont(new Font("Arial", Font.BOLD, 13));
        buttonClients.setBounds(100, 270, 130, 130);
        contentPane.add(buttonClients);

        buttonClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    HomeClient frame = new HomeClient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JButton buttonEmployee = new JButton("Funcionários");
        buttonEmployee.setFont(new Font("Arial", Font.BOLD, 13));
        buttonEmployee.setBounds(260, 270, 130, 130);
        contentPane.add(buttonEmployee);
        buttonEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    HomeEmployee frame = new HomeEmployee();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        JButton buttonVehicle = new JButton("Veículos");
        buttonVehicle.setFont(new Font("Arial", Font.BOLD, 13));
        buttonVehicle.setBounds(580, 270, 130, 130);
        contentPane.add(buttonVehicle);

        buttonVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    HomeVehicle frame = new HomeVehicle();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JButton buttonRent = new JButton("Aluguel");
        buttonRent.setFont(new Font("Arial", Font.BOLD, 13));
        buttonRent.setBounds(420, 270, 130, 130);
        contentPane.add(buttonRent);

        buttonRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    HomeRent frame = new HomeRent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}