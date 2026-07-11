package ca.qc.vc.week3.lesson9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetStringExample {

    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        names.add(new String("Tom"));
        names.add(new String("Tom"));
        names.add(new String("Jerry"));

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();

            System.out.println(
                    "Content: " + name
                            + ", hash code: " + name.hashCode()
            );
        }

        System.out.println("Set size: " + names.size());
    }
}
