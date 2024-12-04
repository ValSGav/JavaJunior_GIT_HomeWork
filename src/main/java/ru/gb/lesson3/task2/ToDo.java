package ru.gb.lesson3.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable {

    //region Поля
    private String title;
    private boolean isDone;
    //endregion

    //region Конструкторы

    public ToDo() {
    }

    public ToDo(String title) {
        this.title = title;
        this.isDone = false;
    }
    //endregion

    //region Методы

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    //endregion

    //region implementation Externalizable
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject( this.title );
        out.writeObject( this.isDone );
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();
    }
    //endregion
}
