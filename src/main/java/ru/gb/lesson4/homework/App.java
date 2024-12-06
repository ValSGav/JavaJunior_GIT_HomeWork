package ru.gb.lesson4.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {

        /**
         * Задание
         * ========
         * Создайте базу данных (например, SchoolDB).
         * В этой базе данных создайте таблцу Courses с полями id (ключ), title, duration
         * Настройте Hibernate для работы с вашей базой данных
         * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate
         * Исользуя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses
         * Убедитесь, что каждая операция выполняется в отдельной транзакции
        * */

        try(SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass( Courses.class ).buildSessionFactory()){
            Session session = sessionFactory.getCurrentSession();

            Courses cours1 = new Courses(1, "ТОЭ" );

        }


    }
}
