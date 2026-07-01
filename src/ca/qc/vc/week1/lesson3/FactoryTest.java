package ca.qc.vc.week1.lesson3;


interface Fruit {
    void buy();
    void manufacture();
    void sell();
}
interface FruitFactory {
    Fruit getFruit();
}
class Apple implements Fruit {
    public void buy() {  System.out.println("buy some apples");   }
    public void manufacture() { System.out.println("manufacture apples");  }
    public void sell() {  System.out.println("sell apples");   }
}
class Banana implements Fruit {
    public void buy() { System.out.println("buy some Banana");   }
    public void manufacture() { System.out.println("manufacture Banana"); }
    public void sell() {  System.out.println("sell Banana"); }
}
class AppleFactory implements FruitFactory {
    public Fruit getFruit() { return new Apple();  }
}
class BananaFactory implements FruitFactory {
    public Fruit getFruit() { return new Banana();  }
}
public class FactoryTest {
    public static void fn(FruitFactory factory) {
        Fruit fruit = factory.getFruit();
        fruit.buy();
        fruit.manufacture();
        fruit.sell();
    }
    public static void main(String[] args) {
        fn(new AppleFactory());
        fn(new BananaFactory());
    }
}
