package ru.gb.lesson1;

public class Lambdas {
    public static void main(String[] args) {

        Foo foo = () -> System.out.println("Hello");
        foo.foo();

    }

    interface Foo{
        void foo();
    }

    static class FooClass implements Foo{
        @Override
        public void foo() {

        }
    }
}
