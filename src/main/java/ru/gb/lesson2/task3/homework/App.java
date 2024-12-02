package ru.gb.lesson2.task3.homework;

public class App {
    public static void main(String[] args) {
        ClassMethodParser parser = new ClassMethodParser();
        System.out.println(parser.getClassMethods( String.class ));
    }
}
