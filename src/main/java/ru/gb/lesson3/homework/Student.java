package ru.gb.lesson3.homework;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Student implements Serializable {
    //region Поля
    private String name;
    private int age;
    transient private double gpa;
    //endregion
    //region Конструкторы
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.gpa = 0;
    }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
//endregion
    //region Методы

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return new ToStringBuilder( this )
                .append( "name", name )
                .append( "age", age )
                .append( "gpa", gpa )
                .toString();
    }
//endregion

}
