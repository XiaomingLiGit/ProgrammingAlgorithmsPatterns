package ca.qc.vc.week1.lesson3;

interface ShippingProvider {
    ShippingLabel createLabel(Order order);
}
class Order {
    private final String orderId;
    private final String destination;
    private final double weightKg;

    public Order(String orderId, String destination, double weightKg) {
        this.orderId = orderId;
        this.destination = destination;
        this.weightKg = weightKg;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeightKg() {
        return weightKg;
    }
}

class ShippingLabel {
    private final String carrier;
    private final String trackingNumber;
    private final double cost;

    public ShippingLabel(String carrier, String trackingNumber, double cost) {
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ShippingLabel{"
                + "carrier='" + carrier + '\''
                + ", trackingNumber='" + trackingNumber + '\''
                + ", cost=$" + String.format("%.2f", cost)
                + '}';
    }
}

class FedExProvider implements ShippingProvider {

    @Override
    public ShippingLabel createLabel(Order order) {
        double cost = 12.00 + 2.50 * order.getWeightKg();

        String trackingNumber =
                "FDX-" + order.getOrderId() + "-"
                        + System.currentTimeMillis();

        System.out.println(
                "FedEx: creating shipment to "
                        + order.getDestination()
        );

        return new ShippingLabel(
                "FedEx",
                trackingNumber,
                cost
        );
    }
}

class UPSProvider implements ShippingProvider {

    @Override
    public ShippingLabel createLabel(Order order) {
        double cost = 10.00 + 3.00 * order.getWeightKg();

        String trackingNumber =
                "UPS-" + order.getOrderId() + "-"
                        + System.currentTimeMillis();

        System.out.println(
                "UPS: booking pickup for "
                        + order.getDestination()
        );

        return new ShippingLabel(
                "UPS",
                trackingNumber,
                cost
        );
    }
}

class DHLProvider implements ShippingProvider {

    @Override
    public ShippingLabel createLabel(Order order) {
        double cost = 15.00 + 2.00 * order.getWeightKg();

        String trackingNumber =
                "DHL-" + order.getOrderId() + "-"
                        + System.currentTimeMillis();

        System.out.println(
                "DHL: creating international shipment to "
                        + order.getDestination()
        );

        return new ShippingLabel(
                "DHL",
                trackingNumber,
                cost
        );
    }
}


public class ShippingTest {
    public static void main(String[] args) {
        Order order = new Order(
                "ORD-1001",
                "Toronto, Canada",
                3.5
        );

        ShippingProvider provider = new FedExProvider();

        ShippingLabel label = provider.createLabel(order);

        System.out.println(label);
    }
}
