package myclasses.paymentStrategy;
import myclasses.BkashPayment;
import myinterface.*;

public class BkashPaymentStrategy implements PaymentStrategy {
    @Override
    public void execute() {
        new BkashPayment();
        System.out.println("Exited from Payment class");
    }
}

