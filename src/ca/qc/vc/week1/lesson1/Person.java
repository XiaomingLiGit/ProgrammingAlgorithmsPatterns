package ca.qc.vc.week1.lesson1;

public class Person {

    private String name;
    private int age;  // internal state hidden

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // controlled access
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public static void main(String[] args){

        final Person p = new Person("Tom");
        p.setName("Jerry");



//        p = new Person("Jerry");



//        Person[] person_list
    }

}