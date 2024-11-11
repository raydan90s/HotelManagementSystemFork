package myclasses.paymentsProcessor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PaymentProcessor {

    public static boolean validateInputs(JTextField number, JPasswordField password) {
        String numberText = number.getText();
        String passText = String.valueOf(password.getPassword());

        // Validate that both the number and password are digits
        for (int i = 0; i < numberText.length(); i++) {
            if (!Character.isDigit(numberText.charAt(i))) {
                JOptionPane.showMessageDialog(
                        null,
                        "Phone Number cannot contain characters",
                        "Input error",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        for (int i = 0; i < passText.length(); i++) {
            if (!Character.isDigit(passText.charAt(i))) {
                JOptionPane.showMessageDialog(
                        null,
                        "PIN number cannot contain characters",
                        "Input error",
                        JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        return true;
    }

    public static boolean validateLength(JTextField number, JPasswordField password) {
        String numberText = number.getText();
        String passText = String.valueOf(password.getPassword());

        if (numberText.length() != 11) {
            JOptionPane.showMessageDialog(
                    null,
                    "Phone number must contain exactly 11 digits",
                    "Length error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (passText.length() != 4) {
            JOptionPane.showMessageDialog(
                    null,
                    "PIN number must contain exactly 4 digits",
                    "Length error",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public static void confirmPayment(JTextField number, JPasswordField password, JFrame paymentFrame) {
        // First validate the inputs
        boolean isInputValid = validateInputs(number, password) && validateLength(number, password);

        if (isInputValid) {
            JOptionPane.showMessageDialog(null, "Payment Confirmed\nThank You For Staying At Tipton");
            System.out.println("Payment Done Successfully");
            new UDashBoard();
            paymentFrame.setVisible(false);
            System.out.println("Exited from BkashPayment class");
        }
    }
}
