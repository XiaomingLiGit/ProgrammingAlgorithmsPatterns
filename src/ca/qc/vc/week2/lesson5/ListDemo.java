package ca.qc.vc.week2.lesson5;

import java.util.ArrayList;

import java.util.HashMap;

class Item {}

public class ListDemo {
    public static void main(String[] args) {


        // query from a DB, SQL
//        ResultSet rs .....

        // static strcuture
        String[] stringArray = new String[10];


        // dynamic strcture
        // the classes inherit from Object
        ArrayList nameList = new ArrayList();

        nameList.add("Charlie");


        nameList.add(new Item());
    }
}
