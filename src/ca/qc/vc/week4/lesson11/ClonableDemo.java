package ca.qc.vc.week4.lesson11;


public class ClonableDemo {

    static class Student implements Cloneable
    {
        int id;
        String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone(); // Calls Object.clone()
        }

    }

    public static void main(String[] args) {
        try {
            Student s1 = new Student(101, "Tom");

            // Safe because Student implements Cloneable
            Student s2 = (Student) s1.clone();

            System.out.println(s2.id + " " + s2.name);

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}



