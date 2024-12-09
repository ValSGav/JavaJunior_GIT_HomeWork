package ru.gb.lesson4.homework;

public interface UtilDB {
    public void createObjectDB(Object obj) throws Exception;

    public Object readObjectDB(int id) throws Exception;

    public void updateObject(Object obj) throws Exception;

    public void deleteObjectDB(Object obj) throws Exception;

}
