package ru.gb.lesson2.task3.homework;

import java.lang.reflect.Method;

public class ClassMethodParser {
    public String getClassMethods(Class<?> clazz){
        StringBuilder result = new StringBuilder();
        Method[] methods = clazz.getMethods();
        for (Method method: methods) {
            result.append( method.getName() ).append( "\n" );

        }
        return result.toString();
    }
}
