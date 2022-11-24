package Client.Validations;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RoleValidator {
    public boolean validate(JTextField field) {
        if (field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o cargo", "Alerta", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        return true;
    }
}
