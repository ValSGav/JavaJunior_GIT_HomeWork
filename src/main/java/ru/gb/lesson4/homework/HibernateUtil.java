package ru.gb.lesson4.homework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil<T> implements UtilDB {

    private final Class<T> typeParametrClass;
    private SessionFactory sessionFactory;

    @Override
    public void createObjectDB(Object obj) throws HibernateException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save( (T) obj );
            session.getTransaction().commit();

        }
    }

    public T readObjectDB(int id) throws HibernateException {
        try (Session session = sessionFactory.getCurrentSession()) {
            //на прорсторах интернетов советуют чтение тоже производить в транзакции
            session.beginTransaction();
            T res = (T) session.get( typeParametrClass, id );
            session.getTransaction().commit();
            return res;
        }
    }

    public void updateObject(Object obj) throws HibernateException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update( (T) obj );
            session.getTransaction().commit();
        }
    }

    public void deleteObjectDB(Object obj) throws HibernateException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete( (T) obj );
            session.getTransaction().commit();
        }
    }

    private SessionFactory initSession() throws HibernateException {
        return new Configuration()
                .configure( "hibernate.cfg.xml" )
                .addAnnotatedClass( typeParametrClass )
                .buildSessionFactory();
    }

    public HibernateUtil(Class<T> typeParametrClass) {
        this.typeParametrClass = typeParametrClass;
        this.sessionFactory = initSession();
    }


}
