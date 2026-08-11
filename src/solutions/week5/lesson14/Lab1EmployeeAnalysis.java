package solutions.week5.lesson14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Lab1EmployeeAnalysis {

    static class Employee {
        private final String name;
        private final String department;
        private final double salary;
        private final boolean active;

        public Employee(
                String name,
                String department,
                double salary,
                boolean active) {

            this.name = name;
            this.department = department;
            this.salary = salary;
            this.active = active;
        }

        public double getSalary() {
            return salary;
        }

        public boolean isActive() {
            return active;
        }

        @Override
        public String toString() {
            return String.format(
                    "%-8s %-12s $%,.2f",
                    name,
                    department,
                    salary
            );
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 95000, true),
                new Employee("Bob", "HR", 72000, true),
                new Employee("Carol", "Finance", 88000, false),
                new Employee("David", "IT", 105000, true),
                new Employee("Eva", "Marketing", 76000, true),
                new Employee("Frank", "Finance", 68000, true),
                new Employee("Grace", "HR", 81000, true),
                new Employee("Henry", "IT", 99000, true)
        );

        // Keep active employees earning more than $70,000
        List<Employee> qualifiedEmployees =
                employees.stream()
                        .filter(Employee::isActive)
                        .filter(employee ->
                                employee.getSalary() > 70000)
                        .collect(Collectors.toList());

        // Display the five highest-paid employees
        System.out.println("Top five employees:");

        qualifiedEmployees.stream()
                .sorted(
                        Comparator.comparingDouble(
                                Employee::getSalary
                        ).reversed()
                )
                .limit(5)
                .forEach(System.out::println);

        // Calculate statistics
        DoubleSummaryStatistics statistics =
                qualifiedEmployees.stream()
                        .mapToDouble(Employee::getSalary)
                        .summaryStatistics();

        System.out.println("\nEmployee statistics:");

        System.out.println(
                "Count: " + statistics.getCount()
        );

        System.out.printf(
                "Average salary: $%,.2f%n",
                statistics.getAverage()
        );

        System.out.printf(
                "Maximum salary: $%,.2f%n",
                statistics.getMax()
        );
    }
}