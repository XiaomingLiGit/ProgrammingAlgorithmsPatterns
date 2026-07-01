package ca.qc.vc.week1.lesson2;

// A simple event listener interface
interface ClickListener {
    void onClick(Button source);
}

// Button class
public class Button {

    private String label;
    private ClickListener listener;

    public Button(String label) {
        this.label = label;
    }

    // Allow external code to register a listener, passing "this" so
    // the listener knows which Button was clicked
    public void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    // Simulate a click event
    public void click() {
        System.out.println(label + " was clicked.");

        if (listener != null) {
            listener.onClick(this);  // pass this Button as the source
        }
    }

    public String getLabel() {
        return label;
    }
}