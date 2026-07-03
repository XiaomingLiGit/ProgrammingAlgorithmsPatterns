package ca.qc.vc.week2.lesson4;

class Pair<T> {

    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}


class AnotherPair<T1, T2> {

    private T1 first;
    private T2 second;

    public AnotherPair() {
        first = null;
        second = null;
    }

    public AnotherPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 newValue) {
        first = newValue;
    }

    public void setSecond(T2 newValue) {
        second = newValue;
    }
}

public class GenericClassTest {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<String>();
        AnotherPair<Integer, String> anotherPair = new AnotherPair<Integer, String>();
    }
}
