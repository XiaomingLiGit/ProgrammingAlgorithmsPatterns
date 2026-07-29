package ca.qc.vc.week4.lesson11;

abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int level);

    protected void passToNext(int level) {
        if (nextHandler != null) {
            nextHandler.handleRequest(level);
        } else {
            System.out.println("No handler can process this request.");
        }
    }
}

// Handles level 1 requests
class BasicSupport extends SupportHandler {

    @Override
    public void handleRequest(int level) {
        if (level == 1) {
            System.out.println("Basic Support handled the request.");
        } else {
            System.out.println("Basic Support passed the request.");
            passToNext(level);
        }
    }
}

// Handles level 2 requests
class TechnicalSupport extends SupportHandler {

    @Override
    public void handleRequest(int level) {
        if (level == 2) {
            System.out.println("Technical Support handled the request.");
        } else {
            System.out.println("Technical Support passed the request.");
            passToNext(level);
        }
    }
}

// Handles level 3 requests
class ManagerSupport extends SupportHandler {

    @Override
    public void handleRequest(int level) {
        if (level == 3) {
            System.out.println("Manager handled the request.");
        } else {
            passToNext(level);
        }
    }
}

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {

        // Create the concrete handlers
        SupportHandler basic = new BasicSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler manager = new ManagerSupport();

        // Build the chain
        basic.setNext(technical);
        technical.setNext(manager);

        // Client sends a level 2 request to the first handler
        System.out.println("Sending a level 2 request:");
        basic.handleRequest(2);
    }
}