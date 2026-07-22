package ca.qc.vc.week3.lesson9;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetObjectDemo {
    private String id;
    private String name;

    public HashSetObjectDemo() {    }

    public HashSetObjectDemo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashSetObjectDemo)) {
            return false;
        }
        HashSetObjectDemo student = (HashSetObjectDemo) obj;
        return this.id.equals(student.id);
    }

    private static void hashset() {
        HashSet<HashSetObjectDemo> hs = new HashSet<>();
        hs.add(new HashSetObjectDemo("1", "Tom"));
        hs.add(new HashSetObjectDemo("2", "Jerry"));
        hs.add(new HashSetObjectDemo("1", "Tom"));
        Iterator<HashSetObjectDemo> iterator = hs.iterator();
        while (iterator.hasNext()) {
            HashSetObjectDemo s = (HashSetObjectDemo) iterator.next();

            System.out.println(
                    "id = " + s.getID()
                            + " name = " + s.getName()
                            + " hashcode = " + s.hashCode()
            );
        }
    }
    public static void main(String[] args) {
        hashset();
    }
}
