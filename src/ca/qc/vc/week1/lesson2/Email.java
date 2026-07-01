package ca.qc.vc.week1.lesson2;

public class Email {

    private String to;
    private String subject;
    private String body;

    public Email setTo(String to) {
        this.to = to;
        return this;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Email setBody(String body) {
        this.body = body;
        return this;
    }

    public void send() {
        // Dummy send logic
        System.out.println("Sending email:");
        System.out.println("  To:      " + to);
        System.out.println("  Subject: " + subject);
        System.out.println("  Body:    " + body);
    }

    public static void main(String[] args) {
        // Notice how we can chain calls because each setter returns "this"
        new Email()
                .setTo("alice@example.com")
                .setSubject("Meeting Reminder")
                .setBody("Don't forget our meeting tomorrow at 10AM.")
                .send();
    }
}