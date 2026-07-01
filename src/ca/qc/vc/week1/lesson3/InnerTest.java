package ca.qc.vc.week1.lesson3;


class Outer {

    class Inner1 {
        void fn() {
            System.out.println("fn in Inner1");
        }
    }

    class Inner2 {
        void fn() {
            System.out.println("fn in inner2");
        }
    }

    public Inner1 getInner1() {
        return new Inner1();
    }

    public Inner2 getInner2() {
        return new Inner2();
    }
}

public class InnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner1 inner1 = outer.getInner1();
        Outer.Inner2 inner2 = outer.getInner2();

        inner1.fn();
        inner2.fn();
    }
}
