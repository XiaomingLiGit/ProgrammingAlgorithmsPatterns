package ca.qc.vc.week1.lesson2;


class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Woof!");
    }
}

public class DowncastingTest {
    public static Animal getAnimal(boolean wantDog) {
        return wantDog ? new Dog() : new Animal();
    }

    public static void main(String[] args) {
        Animal a1 = getAnimal(true);
        Animal a2 = getAnimal(false);

        // Unsafe downcast: might throw ClassCastException
        Dog d1 = (Dog) a1;
        d1.bark();  // prints "Woof!"

        try {
            Dog d2 = (Dog) a2;  // Runtime exception here
            d2.bark();
        } catch (ClassCastException e) {
            System.err.println("Cannot cast a2 to Dog!");
        }

        // Safe downcast with instanceof
        if (a2 instanceof Dog) {
            Dog d3 = (Dog) a2;
            d3.bark();
        } else {
            System.out.println("a2 is not a Dog.");
        }
    }
}
