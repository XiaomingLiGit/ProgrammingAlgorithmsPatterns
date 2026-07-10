package ca.qc.vc.week2.lesson6;

interface Payable {
    double getPayment();
}

class Employee implements Payable, Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getPayment() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }
}

public class MultipleBoundsDemo2 {

    public static <T extends Payable & Comparable<T>> T higherPaid(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 80000);
        Employee e2 = new Employee("Bob", 95000);

        Employee result = higherPaid(e1, e2);

        System.out.println(result);
        System.out.println(result.getPayment());
    }
}