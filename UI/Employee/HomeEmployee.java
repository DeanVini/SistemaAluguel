package Employee;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeEmployee extends JFrame {
    private JPanel contentPane;
    public static void main(String[] args) {
        try {
            HomeEmployee frame = new HomeEmployee();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HomeEmployee(){
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("Funcionários");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton buttonRegister = new JButton("Cadastrar");
        buttonRegister.setFont(new Font("Arial", Font.BOLD, 13));
        buttonRegister.setBounds(160, 270, 130, 130);
        contentPane.add(buttonRegister);
        
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateEmployee frame = new CreateEmployee();
                    frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        JButton buttonSearch = new JButton("Consultar");
        buttonSearch.setFont(new Font("Arial", Font.BOLD, 13));
        buttonSearch.setBounds(320, 270, 130, 130);
        contentPane.add(buttonSearch);

        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchEmployee frame = new SearchEmployee();
                    frame.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
