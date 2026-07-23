package ca.qc.vc.week4.lesson10;

import java.util.*;

class Student {
    String id;

    Student(String id) { this.id = id;  }
    @Override
    public int hashCode() {  return Objects.hash(id);   }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return Objects.equals(this.id, other.id);
    }
    @Override
    public String toString() {
        return "Student{id='" + id + "'}";
    }
}

public class HashMapMutableKey {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();

        Student s = new Student("1001");

        // use a mutable object (student) as the key
        map.put(s, "Alice");

        System.out.println(map.get(s));        // Alice

        // change the key of HashMap (by changing student id)
        s.id = "2002";

        System.out.println(map.get(s));        // null
        System.out.println(map.containsKey(s)); // false

        System.out.println(map);               // data still exists

    }
}