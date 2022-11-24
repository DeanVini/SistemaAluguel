package Client.Validations;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.Person.ClientDatabase;

public class CPFValidator {
    public boolean validate(JTextField field) {
        if (field.getText().trim().length() < 14) {
            JOptionPane.showMessageDialog(null, "Informe o CPF");
            return false;
        }
        ClientDatabase clientDatabase = new ClientDatabase();
        try {
            if (clientDatabase.cpfExists(field.getText())) {
                JOptionPane.showMessageDialog(null, "O CPF informado já existe.", "Alerta", JOptionPane.PLAIN_MESSAGE);
                return false;
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    
        return true;
    }
}
