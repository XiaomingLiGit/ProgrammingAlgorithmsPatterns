package ca.qc.vc.week1.lesson1;


class Engine {
    public void start() {}
    public void accelerate() {}
    public void stop() {}
}

class Wheel {
    public void inflate(int n) {}
}

class Window {
    public void rollup() {}
    public void rooldown() {}
}

class Door {
    public Window window = new Window();

    public void open() {}
    public void close() {}
}

class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door left = new Door();
    public Door right = new Door();

    public Car() {
        for (int i = 0; i < 4; ++i) {
            wheel[i] = new Wheel();
        }
    }
}

public class Composition {
}
