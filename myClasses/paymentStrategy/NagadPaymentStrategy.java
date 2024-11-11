package myclasses.paymentStrategy;
import myclasses.NagadPayment;
import myinterface.*;

public class NagadPaymentStrategy implements PaymentStrategy {
    @Override
    public void execute() {
        new NagadPayment();
        System.out.println("Exited from Payment class");
    }
}