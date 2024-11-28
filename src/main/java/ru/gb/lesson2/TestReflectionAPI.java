package ru.gb.lesson2;

public class TestReflectionAPI {
    private int counter;
    public boolean flag;

    public int getCounter() {
        return counter;
    }

    public TestReflectionAPI(int counter, boolean flag) {
        this.counter = counter;
        this.flag = flag;
    }
}
