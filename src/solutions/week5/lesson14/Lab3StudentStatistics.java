package solutions.week5.lesson14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Lab3StudentStatistics {

    static class Student {
        private final String name;
        private final String department;
        private final double gpa;

        public Student(
                String name,
                String department,
                double gpa) {

            this.name = name;
            this.department = department;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s (GPA: %.2f)",
                    name,
                    gpa
            );
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "Computer Science", 3.80),
                new Student("Bob", "Computer Science", 3.60),
                new Student("Carol", "Business", 3.70),
                new Student("David", "Computer Science", 3.95),
                new Student("Eva", "Business", 3.90),
                new Student("Frank", "Mathematics", 3.85),
                new Student("Grace", "Mathematics", 3.75)
        );

        // Group students by department
        Map<String, List<Student>> studentsByDepartment =
                students.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Student::getDepartment,
                                        TreeMap::new,
                                        Collectors.toList()
                                )
                        );

        // Calculate average GPA by department
        Map<String, Double> averageGpaByDepartment =
                students.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Student::getDepartment,
                                        TreeMap::new,
                                        Collectors.averagingDouble(
                                                Student::getGpa
                                        )
                                )
                        );

        // Find the highest-GPA student in each department
        Map<String, Optional<Student>> highestByDepartment =
                students.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Student::getDepartment,
                                        TreeMap::new,
                                        Collectors.maxBy(
                                                Comparator.comparingDouble(
                                                        Student::getGpa
                                                )
                                        )
                                )
                        );

        // Display the results
        studentsByDepartment.forEach(
                (department, departmentStudents) -> {

                    String studentNames =
                            departmentStudents.stream()
                                    .map(Student::getName)
                                    .collect(
                                            Collectors.joining(", ")
                                    );

                    String highestStudent =
                            highestByDepartment
                                    .get(department)
                                    .map(Student::toString)
                                    .orElse("No student");

                    System.out.println(
                            "\nDepartment: " + department
                    );

                    System.out.println(
                            "Students: " + studentNames
                    );

                    System.out.printf(
                            "Average GPA: %.2f%n",
                            averageGpaByDepartment.get(department)
                    );

                    System.out.println(
                            "Highest GPA: " + highestStudent
                    );
                }
        );
    }
}