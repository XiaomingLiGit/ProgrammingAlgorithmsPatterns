package solutions.week3.lesson9;

import java.util.*;

class Order {
    private String orderId;
    private String customerName;
    private String sku;
    private int quantity;
    private boolean urgent;
    private int priority;
    private int submissionOrder;

    public Order(String orderId, String customerName, String sku,
                 int quantity, boolean urgent, int priority, int submissionOrder) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.sku = sku;
        this.quantity = quantity;
        this.urgent = urgent;
        this.priority = priority;
        this.submissionOrder = submissionOrder;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public int getPriority() {
        return priority;
    }

    public int getSubmissionOrder() {
        return submissionOrder;
    }

    @Override
    public String toString() {
        return "Order{id='" + orderId +
                "', customer='" + customerName +
                "', sku='" + sku +
                "', quantity=" + quantity +
                ", urgent=" + urgent +
                ", priority=" + priority +
                ", order=" + submissionOrder + "}";
    }
}

class OrderFulfillmentSystem {
    private List<Order> orderHistory = new ArrayList<>();
    private Set<String> processedOrderIds = new HashSet<>();
    private Queue<Order> regularOrders = new ArrayDeque<>();

    private PriorityQueue<Order> urgentOrders = new PriorityQueue<>(
            Comparator.comparingInt(Order::getPriority)
                    .thenComparingInt(Order::getSubmissionOrder)
    );

    private Map<String, Integer> inventory = new HashMap<>();

    public void addInventory(String sku, int quantity) {
        inventory.put(sku, quantity);
    }

    public void submitOrder(Order order) {
        if (order.isUrgent()) {
            urgentOrders.offer(order);
            System.out.println("Urgent order submitted: " + order);
        } else {
            regularOrders.offer(order);
            System.out.println("Regular order submitted: " + order);
        }
    }

    public void processNextOrder() {
        Order order;

        if (!urgentOrders.isEmpty()) {
            order = urgentOrders.poll();
        } else if (!regularOrders.isEmpty()) {
            order = regularOrders.poll();
        } else {
            System.out.println("No orders to process.");
            return;
        }

        if (processedOrderIds.contains(order.getOrderId())) {
            System.out.println("Duplicate order skipped: " + order.getOrderId());
            return;
        }

        String sku = order.getSku();
        int requiredQuantity = order.getQuantity();
        int availableQuantity = inventory.getOrDefault(sku, 0);

        if (availableQuantity >= requiredQuantity) {
            inventory.put(sku, availableQuantity - requiredQuantity);
            processedOrderIds.add(order.getOrderId());
            orderHistory.add(order);

            System.out.println("Order fulfilled: " + order);
        } else {
            System.out.println("Insufficient inventory for order: " + order);
        }
    }

    public void processAllOrders() {
        while (!urgentOrders.isEmpty() || !regularOrders.isEmpty()) {
            processNextOrder();
            System.out.println("Current inventory: " + inventory);
            System.out.println();
        }
    }

    public void printOrderHistory() {
        System.out.println("Order history:");
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }

    public void printProcessedOrderIds() {
        System.out.println("Processed order IDs: " + processedOrderIds);
    }
}

public class OrderFulfillmentSystemDemo {
    public static void main(String[] args) {
        OrderFulfillmentSystem system = new OrderFulfillmentSystem();

        system.addInventory("SKU-A", 10);
        system.addInventory("SKU-B", 5);
        system.addInventory("SKU-C", 20);

        system.submitOrder(new Order("O1001", "Alice", "SKU-A", 2, false, 0, 1));
        system.submitOrder(new Order("O1002", "Bob", "SKU-B", 3, true, 1, 2));
        system.submitOrder(new Order("O1003", "Charlie", "SKU-A", 4, false, 0, 3));
        system.submitOrder(new Order("O1004", "David", "SKU-C", 10, true, 2, 4));
        system.submitOrder(new Order("O1005", "Eva", "SKU-B", 4, true, 1, 5));
        system.submitOrder(new Order("O1006", "Frank", "SKU-C", 5, false, 0, 6));

        // Duplicate order ID
        system.submitOrder(new Order("O1002", "Grace", "SKU-A", 1, false, 0, 7));

        System.out.println("\nProcessing orders:");
        system.processAllOrders();

        system.printOrderHistory();
        system.printProcessedOrderIds();
    }
}