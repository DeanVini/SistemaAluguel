package Client.Validations;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgeValidator {
    public boolean validate(JTextField field) {
        if (field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a sua idade", "Alerta", JOptionPane.PLAIN_MESSAGE);
            return false;
        }

        try {
            int age = Integer.parseInt(field.getText());
            if (age < 18) {
                JOptionPane.showMessageDialog(null, "O cliente não possui idade para alugar um veículo", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Idade informada não é válida", "Alerta", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }
}
