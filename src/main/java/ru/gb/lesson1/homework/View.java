package ru.gb.lesson1.homework;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class View {
    void  showMenu(List<String> items){
        AtomicInteger counter = new AtomicInteger(1);
        System.out.println("Выберите пункт меню: ");
        items.stream()
                .map(s -> "\t" + counter.getAndIncrement() +  ". " + s)
                .forEach(System.out::println);
        System.out.print("::");
    }
}
