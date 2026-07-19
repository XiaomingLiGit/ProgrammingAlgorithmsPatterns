package ca.qc.vc.week1.lesson1;


// define the abstraction
interface PaymentProcessor {
    void processPayment(double amount);
}

// hide complexity behind the interface
class PayPalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // imagine complex API calls here
        System.out.println("Processing $" + amount + " via PayPal");
    }
}

class StripeProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // complex logic hidden
        System.out.println("Processing $" + amount + " via Stripe");
    }
}


class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {}
}


public class Inheritance {
    public static void main(String[] args) {

    }
}
