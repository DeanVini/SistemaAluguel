package Client.Validations;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.Person.ClientDatabase;

public class EmailValidator {
    public boolean validate(JTextField field) {
        if (field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o seu email", "Alerta", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        if (!field.getText().contains("@")) {
            JOptionPane.showMessageDialog(null, "Informe um email válido", "Alerta", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        ClientDatabase clientDatabase = new ClientDatabase();
        try {
            if (clientDatabase.emailExists(field.getText())) {
                JOptionPane.showMessageDialog(null, "O email informado já existe.", "Alerta",
                        JOptionPane.PLAIN_MESSAGE);
                return false;
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
