package ru.gb.lesson3.homework;

import java.util.ArrayList;
import java.util.List;

public class App {
    /*
    Разработайте класс Student  с полями String name, int age, transient double GPA(средний балл)
    Обеспечьте поддержку сериализации этого класса
    Создайте объект класса Student и инициализируйте его данными
    Сериализуйте этот объект в файл
    Десериализуйте этот объект обратно в программу из файла
    Выведите все поля объекта, ключая GPA и обсудите, почему значение GPA не было сохранено/восстановлено
    ++ реализовать сериализацию json и  xml
    * */

    List<Student> students = new ArrayList<>();

    public static List<Student> generateListOfStudents(){
        List<Student> generatesStudents= new ArrayList<>();
        generatesStudents.add(new Student("Alex", 26));
        generatesStudents.add(new Student("Mary", 21));
        generatesStudents.add(new Student("Suzi", 17));
        generatesStudents.add(new Student("Killian", 29));
        return generatesStudents;
    }

}