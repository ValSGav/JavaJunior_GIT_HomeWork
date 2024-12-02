package ru.gb.lesson2.task3;

import java.util.UUID;

public class App {
    public static void main(String[] args) throws IllegalAccessException {

        Employee user = new Employee( "Stanislav", "sample@gmail.com" );
        UUID pk = UUID.randomUUID();
        user.setId( pk );

        QueryBuilder queryBuilder = new QueryBuilder();
        String inserQuery = queryBuilder.buildInsertQuery( user );
        System.out.println(inserQuery);

    }
}
