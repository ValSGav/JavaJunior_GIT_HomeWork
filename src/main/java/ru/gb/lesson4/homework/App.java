package ru.gb.lesson4.homework;


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



        Courses cours1 = new Courses( "ТОЭ" );
        Courses cours2 = new Courses( "Начертательная геометрия" );
        Courses cours3 = new Courses( "Сопрамат" );
        Courses cours4 = new Courses( "Пение" );

        cours1.setDuration( 3.7 );
        cours2.setDuration( 6.5 );
        cours3.setDuration( 1.1 );
        cours4.setDuration( 1.3 );


        HibernateUtil<Courses> hibernateUtil = new HibernateUtil<>( Courses.class );
        PersistentManagerUtil<Courses> pmUtil = new PersistentManagerUtil<>( hibernateUtil );

        try {
            pmUtil.createObjectDB( cours1 );
            pmUtil.createObjectDB( cours2 );
            pmUtil.createObjectDB( cours3 );
            pmUtil.createObjectDB( cours4 );
            System.out.println( "Записали в базу четыре объекта" );

            System.out.println( "Прочитали объект с id 3: " + pmUtil.readObjectDB( 3 ) );

            cours2.setTitle( "Рисование" );
            cours2.setDuration( 8.8 );
            hibernateUtil.updateObject( cours2 );

            System.out.println( pmUtil.readObjectDB( 2 ) );


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
