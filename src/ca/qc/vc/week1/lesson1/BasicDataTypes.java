package ca.qc.vc.week1.lesson1;


import java.util.ArrayList;
import java.util.List;

/**
 * this code snippet shows the eight basic data types in Java
 */
public class BasicDataTypes {
    public static void main(String[] args) {
        byte smallNumber = 100;
        short shortNumber = 30000;
        int age = 25;
        long population = 8_000_000_000L;

        float price = 19.99f;
        double distance = 12345.6789;

        char grade = 'A';
        boolean isJavaFun = true;


        System.out.println("byte: " + smallNumber);
        System.out.println("short: " + shortNumber);
        System.out.println("int: " + age);
        System.out.println("long: " + population);
        System.out.println("float: " + price);
        System.out.println("double: " + distance);
        System.out.println("char: " + grade);
        System.out.println("boolean: " + isJavaFun);
    }


}
