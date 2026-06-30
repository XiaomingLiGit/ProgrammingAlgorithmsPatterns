package ca.qc.vc.week1.lesson1;


// base class
abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();
}

// subclass reuses and extends
class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

// another subclass
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}


public class Zoo {
}
