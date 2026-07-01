package ca.qc.vc.week1.lesson2;

public class StaticNonStaticDemo {

    // ============================
    // 1. Static (Class-Level) Field
    // ============================
    // This field is shared by all instances of StaticNonStaticDemo.
    // You can access it as StaticNonStaticDemo.staticCount (without creating an object).
    private static int staticCount = 0;

    // ============================
    // 2. Non-Static (Instance-Level) Field
    // ============================
    // Each object of StaticNonStaticDemo has its own copy of nonStaticValue.
    private int nonStaticValue;

    // ============================
    // 3. Constructor
    // ============================
    // When you create a new instance, you set nonStaticValue, and you increment the shared staticCount.
    public StaticNonStaticDemo(int value) {
        this.nonStaticValue = value;  // set the instance's field
        staticCount++;                // increment the shared, class-level counter
    }

    // ============================
    // 4. Static (Class-Level) Method
    // ============================
    // - Can only directly access other static fields/methods.
    // - Meant to operate on class-level data (or utility behavior).
    public static void showStaticInfo() {
        System.out.println("Called showStaticInfo()");
        System.out.println("  -> staticCount = " + staticCount);

        // Cannot do this:
        // System.out.println(nonStaticValue);
        // because nonStaticValue belongs to an instance, not to the class itself.
    }

    // ============================
    // 5. Non-Static (Instance-Level) Method
    // ============================
    // - Can access both static and non-static fields/methods.
    // - Operates on "this" particular object.
    public void showInstanceInfo() {
        System.out.println("Called showInstanceInfo() on this object:");
        System.out.println("  -> nonStaticValue = " + nonStaticValue);
        System.out.println("  -> staticCount    = " + staticCount);

        // Notice: we are allowed to refer to staticCount here,
        // because staticCount belongs to the class.
    }

    // ============================
    // 6. Main Method to Demonstrate Usage
    // ============================
    public static void main(String[] args) {

        System.out.println("=== Before creating any objects ===");

        // We can call a static method before any instances exist:
        StaticNonStaticDemo.showStaticInfo();

        // Output:
        //   Called showStaticInfo()
        //   -> staticCount = 0

        System.out.println("\n=== Create first instance: objA ===");
        StaticNonStaticDemo objA = new StaticNonStaticDemo(10);

        // Now staticCount has become 1, and objA.nonStaticValue == 10.

        // Call instance method on objA
        objA.showInstanceInfo();

        // Output:
        //   Called showInstanceInfo() on this object:
        //   -> nonStaticValue = 10
        //   -> staticCount    = 1

        System.out.println("\n=== Create second instance: objB ===");
        StaticNonStaticDemo objB = new StaticNonStaticDemo(20);

        objB.showInstanceInfo();

        // 1) Accessing static field via class name (preferred):
        System.out.println("Static count via class: "
                + StaticNonStaticDemo.staticCount);

        // 2) Accessing static field via instance (compiles, but not recommended):
        System.out.println("Static count via objB:  " + objB.staticCount);

        // 3) Accessing non-static field via instance (valid):
        System.out.println("objA's nonStaticValue:  " + objA.nonStaticValue);

        // 4) Non-static cannot be accessed via class name directly:
        // System.out.println(StaticNonStaticDemo.nonStaticValue); // DOES NOT COMPILE

        // 5) Calling static method via class name (preferred):
        StaticNonStaticDemo.showStaticInfo();

        // 6) Calling non-static method via instance (only way to do it):
        objB.showInstanceInfo();
    }
}