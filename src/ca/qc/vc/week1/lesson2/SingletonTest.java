package ca.qc.vc.week1.lesson2;
//import java.math.BigInteger
/**
 * this code snippet shows a simple version of Singleton
 * lazy mode and thread-unsafe
 */
class Singleton {

    private static Singleton instance;

    private Singleton() {
        // private constructor prevents external instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

//  lazy mode and thread-safe
//class Singleton {
//
//    private Singleton() {}
//
//    private static class Holder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return Holder.INSTANCE;
//    }
//}

public class SingletonTest {

    public static void main(String[] args) {
        // Usage:
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("s1 reference is " + s1);
        System.out.println("s2 reference is " + s2);

        if  (s1 == s2) {System.out.println("the same instance");}
        else {System.out.println("different instances" );}

        System.out.println("s1 hash code is " + s1.hashCode());
        System.out.println("s2 hash code is " + s2.hashCode());

        // s1 and s2 refer to the same instance.
    }
}