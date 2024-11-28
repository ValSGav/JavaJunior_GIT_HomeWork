package ru.gb.lesson2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> cl = Class.forName( "ru.gb.lesson2.TestReflectionAPI" );
        Object ob = cl.getConstructors(  )[0].newInstance(1, true);
        Field[] fields = ob.getClass().getDeclaredFields();
        for (Field fl: fields) {
            System.out.println(fl.getName() + fl.getGenericType());
        }




    }



}
