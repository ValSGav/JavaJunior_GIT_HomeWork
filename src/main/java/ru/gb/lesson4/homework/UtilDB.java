package ru.gb.lesson4.homework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface UtilDB<T> {
    public void createObjectDB(T obj) throws Exception;

    public T readObjectDB(int id) throws Exception;

    public void updateObject(T obj) throws Exception;

    public void deleteObjectDB(T obj) throws Exception;

}
