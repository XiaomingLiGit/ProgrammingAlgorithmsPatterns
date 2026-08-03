package ca.qc.vc.week4.lesson12;

interface Coffee {
    double cost();
    String description();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 2.0;
    }

    public String description() {
        return "Simple coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }

    public String description() {
        return coffee.description() + ", milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.2;
    }

    public String description() {
        return coffee.description() + ", sugar";
    }
}

class CreamDecorator extends CoffeeDecorator {
    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.3;
    }

    public String description() {
        return coffee.description() + ", cream";
    }
}


public class CoffeeDecoratorExample {
    public static void main(String[] args) {
//        Coffee coffee = new SimpleCoffee();
//
//        coffee = new MilkDecorator(coffee);
//        coffee = new SugarDecorator(coffee);

        Coffee coffeeWithMilkSugarCream = new CreamDecorator(new SugarDecorator(new MilkDecorator(new SimpleCoffee())));

        System.out.println(coffeeWithMilkSugarCream.description());
        System.out.println("Cost: $" + coffeeWithMilkSugarCream.cost());
    }
}
