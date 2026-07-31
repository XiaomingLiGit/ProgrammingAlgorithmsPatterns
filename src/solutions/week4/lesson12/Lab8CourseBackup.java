package solutions.week4.lesson12;

import java.io.*;
import java.util.*;

public class Lab8CourseBackup {

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private double score;

        public Student(int id, String name, double score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    static class Instructor implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private String department;

        public Instructor(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Instructor{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

    static class Course implements Serializable {
        private static final long serialVersionUID = 1L;

        private String courseCode;
        private String title;
        private Instructor instructor;
        private ArrayList<Student> students;

        public Course(String courseCode, String title, Instructor instructor) {
            this.courseCode = courseCode;
            this.title = title;
            this.instructor = instructor;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudentById(int id) {
            students.removeIf(student -> student.getId() == id);
        }

        public void displayCourseInfo() {
            System.out.println("Course Code: " + courseCode);
            System.out.println("Title: " + title);
            System.out.println("Instructor: " + instructor);

            System.out.println("Enrolled Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void saveCourse(Course course, String fileName) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(course);
            System.out.println("Course object saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Course loadCourse(String fileName) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            return (Course) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String fileName = "course.dat";

        Instructor instructor =
                new Instructor(1001, "Dr. Smith", "Computer Science");

        Course course =
                new Course("CS101", "Introduction to Java Programming", instructor);

        course.addStudent(new Student(1, "Alice", 88.5));
        course.addStudent(new Student(2, "Bob", 91.0));
        course.addStudent(new Student(3, "Charlie", 79.5));

        saveCourse(course, fileName);

        Course restoredCourse = loadCourse(fileName);

        if (restoredCourse != null) {
            System.out.println("\nRestored course information:");
            restoredCourse.displayCourseInfo();

            System.out.println("\nUpdating course after deserialization...");
            restoredCourse.addStudent(new Student(4, "Diana", 95.0));
            restoredCourse.removeStudentById(2);

            saveCourse(restoredCourse, fileName);

            System.out.println("\nUpdated course information:");
            restoredCourse.displayCourseInfo();
        }
    }
}