package ca.qc.vc.week1.lesson3;

abstract class PaymentService {

    // Template Method: fixed payment workflow
    public final void pay(double amount) {
        validate(amount);
        charge(amount);       // varies by provider
        recordTransaction(amount);
        notifyCustomer();
    }

    private void validate(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount.");
        }
        System.out.println("Validating payment...");
    }

    protected abstract void charge(double amount);

    private void recordTransaction(double amount) {
        System.out.println("Recording transaction: $" + amount);
    }

    private void notifyCustomer() {
        System.out.println("Sending payment confirmation.");
    }
}

class StripePaymentService extends PaymentService {

    @Override
    protected void charge(double amount) {
        System.out.println("Charging $" + amount + " through Stripe.");
    }
}

class PayPalPaymentService extends PaymentService {

    @Override
    protected void charge(double amount) {
        System.out.println("Charging $" + amount + " through PayPal.");
    }
}


public class PaymentTemplate {
    public static void main(String[] args) {
        PaymentService payment = new StripePaymentService();
        payment.pay(29.99);

        System.out.println();

        payment = new PayPalPaymentService();
        payment.pay(29.99);
    }
}
