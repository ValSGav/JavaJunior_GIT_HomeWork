package ru.gb.lesson4.homework;

public class PersistentManagerUtil<T> {
    public UtilDB util;

    public PersistentManagerUtil(UtilDB util) {
        this.util = util;
    }

    public void createObjectDB(Object obj) throws Exception {
        util.createObjectDB( obj );
    }

    public T readObjectDB(int id) throws Exception {
        return (T) util.readObjectDB( id );
    }

    public void updateObject(Object obj) throws Exception {
        util.updateObject( obj );
    }

    public void deleteObjectDB(Object obj) throws Exception {
        util.deleteObjectDB( obj );
    }

}
