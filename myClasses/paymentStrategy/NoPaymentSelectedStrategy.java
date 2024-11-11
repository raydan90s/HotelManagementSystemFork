package myclasses.paymentStrategy;
import myinterface.*;

public class NoPaymentSelectedStrategy implements PaymentStrategy {
    @Override
    public void execute() {
        JOptionPane.showMessageDialog(
            null,
            "You forgot to select your payment method.",
            "Warning!",
            JOptionPane.WARNING_MESSAGE);
    }
}