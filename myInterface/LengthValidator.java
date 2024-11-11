package myinterface;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface LengthValidator {
    boolean inputLength(JTextField number, JPasswordField password);
}
