package ru.gb.lesson3.task1;

import java.io.Serializable;

public class UserData implements Serializable {
    private String name;
    private int age;
    transient String password;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder( this )
                .append( "name", name )
                .append( "age", age )
                .append( "password", password )
                .toString();
    }

    public int getAge() {
        return age;
    }



    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
