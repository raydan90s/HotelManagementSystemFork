package myinterface;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import myclasses.BkashPayment;

public interface PaymentProcessorInterface {
    void confirmPayment(JTextField numField, JPasswordField passField, BkashPayment bkashPayment);
}
