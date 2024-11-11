package myinterface;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface InputValidator {
    /**
   * Valida que el número y el PIN contengan solo dígitos.
   *
   * @param number Campo que representa el número de teléfono.
   * @param password Campo que representa el PIN.
   * @return true si ambos campos contienen solo dígitos; false en caso contrario.
   */
  boolean inputValidation(JTextField number, JPasswordField password);
}

