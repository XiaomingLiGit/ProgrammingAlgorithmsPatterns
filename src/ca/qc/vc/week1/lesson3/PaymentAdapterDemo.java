package ca.qc.vc.week1.lesson3;

// PaymentAdapterDemo.java

// Target interface: the interface expected by our application
interface PaymentProcessor {
    boolean pay(double amountInDollars);
}

// --------------------------------------------------
// Adaptee 1: third-party Stripe API
// It expects an amount in cents and uses charge().
// --------------------------------------------------
class StripeApi {
    public boolean charge(int amountInCents) {
        System.out.println(
                "Stripe API: charged " + amountInCents + " cents."
        );
        return true;
    }
}

// Adapter: translates our interface into Stripe's interface
class StripeAdapter implements PaymentProcessor {
    private StripeApi stripeApi = new StripeApi();

    @Override
    public boolean pay(double amountInDollars) {
        int amountInCents = (int) Math.round(amountInDollars * 100);

        return stripeApi.charge(amountInCents);
    }
}

// --------------------------------------------------
// Adaptee 2: third-party PayPal API
// It expects a formatted String and uses sendPayment().
// --------------------------------------------------
class PayPalApi {
    public String sendPayment(String amount) {
        System.out.println(
                "PayPal API: payment request sent for " + amount + "."
        );
        return "SUCCESS";
    }
}

// Adapter: translates our interface into PayPal's interface
class PayPalAdapter implements PaymentProcessor {
    private PayPalApi payPalApi = new PayPalApi();

    @Override
    public boolean pay(double amountInDollars) {
        String formattedAmount = String.format("$%.2f", amountInDollars);

        String result = payPalApi.sendPayment(formattedAmount);

        return result.equals("SUCCESS");
    }
}

// --------------------------------------------------
// Adaptee 3: third-party Square API
// It expects a transaction ID and an amount.
// --------------------------------------------------
class SquareApi {
    public boolean createTransaction(String transactionId, double amount) {
        System.out.println(
                "Square API: transaction " + transactionId
                        + " created for $" + amount + "."
        );
        return true;
    }
}

// Adapter: translates our interface into Square's interface
class SquareAdapter implements PaymentProcessor {
    private SquareApi squareApi = new SquareApi();

    @Override
    public boolean pay(double amountInDollars) {
        String transactionId = "TXN-" + System.currentTimeMillis();

        return squareApi.createTransaction(transactionId, amountInDollars);
    }
}

// --------------------------------------------------
// Client code: only knows PaymentProcessor.
// --------------------------------------------------
public class PaymentAdapterDemo {

    public static void checkout(PaymentProcessor processor, double amount) {
        boolean success = processor.pay(amount);

        if (success) {
            System.out.println("Payment completed successfully.\n");
        } else {
            System.out.println("Payment failed.\n");
        }
    }

    public static void main(String[] args) {

        PaymentProcessor stripe = new StripeAdapter();
        PaymentProcessor paypal = new PayPalAdapter();
        PaymentProcessor square = new SquareAdapter();

        checkout(stripe, 19.99);
        checkout(paypal, 25.50);
        checkout(square, 100.00);
    }
}