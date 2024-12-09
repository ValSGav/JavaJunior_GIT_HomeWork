package ru.gb.lesson4.homework;

public interface UtilDB {
    void createObjectDB(Object obj) throws Exception;

    Object readObjectDB(int id) throws Exception;

    void updateObject(Object obj) throws Exception;

    void deleteObjectDB(Object obj) throws Exception;

}
