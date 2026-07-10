package ca.qc.vc.week2.lesson6;


import java.util.*;

class Course implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}

public class IterableDemo {
    public static void main(String[] args) {
        Course course = new Course();

        course.addStudent(new Student("Alice", 3.8));
        course.addStudent(new Student("Bob", 3.5));
        course.addStudent(new Student("Charlie", 3.9));

        for (Student s : course) {
            System.out.println(s);
        }
    }
}