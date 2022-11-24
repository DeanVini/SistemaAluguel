package Vehicle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vehicle.Air.CreateAir;
import Vehicle.Land.CreateLand;
import Vehicle.Maritime.CreateMaritime;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VehicleTypes extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        try {
            VehicleTypes frame = new VehicleTypes();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VehicleTypes(){
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("Tipo do Veículo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton buttonAir = new JButton("Aério");
        buttonAir.setFont(new Font("Arial", Font.BOLD, 13));
        buttonAir.setBounds(160, 270, 130, 130);
        contentPane.add(buttonAir);

        buttonAir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateAir frame = new CreateAir();
                    frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        

        JButton buttonLand = new JButton("Terrestre");
        buttonLand.setFont(new Font("Arial", Font.BOLD, 13));
        buttonLand.setBounds(320, 270, 130, 130);
        contentPane.add(buttonLand);

        buttonLand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateLand frame = new CreateLand();
                    frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        JButton buttonMaritime = new JButton("Maritimo");
        buttonMaritime.setFont(new Font("Arial", Font.BOLD, 13));
        buttonMaritime.setBounds(480, 270, 130, 130);
        contentPane.add(buttonMaritime);

        buttonMaritime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateMaritime frame = new CreateMaritime();
                    frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        

        

    }
}
