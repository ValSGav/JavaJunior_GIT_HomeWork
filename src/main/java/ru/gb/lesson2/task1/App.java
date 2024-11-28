package ru.gb.lesson2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName( "ru.gb.lesson2.task1.Person" );
        Field[] fields= personalClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println("Поле: " + field.getName());
        }

        Constructor[] constructors = personalClass.getConstructors();

        Object personsInstance = constructors[0].newInstance( null );

        Field nameField = personalClass.getDeclaredField( "name" );
        nameField.setAccessible( true );
        nameField.set( personsInstance, "Alice" );

        Field ageField = personalClass.getDeclaredField( "age" );
        ageField.setAccessible( true );
        ageField.set(personsInstance, 27 );

        Method displayInfoMethod = personalClass.getDeclaredMethod( "displayInfo");

        displayInfoMethod.invoke( personsInstance );



    }
}
