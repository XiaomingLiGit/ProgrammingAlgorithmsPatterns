package ca.qc.vc.week3.lesson8;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
        public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; ++i)
            list.add(i);

        for (int j = 9; j >= 0; --j)
            System.out.println(list.get(j));

        System.out.println(list.size());

        Iterator<Integer> it = list.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }
}
