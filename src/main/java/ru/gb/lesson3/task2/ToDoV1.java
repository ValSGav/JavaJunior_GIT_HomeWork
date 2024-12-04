package ru.gb.lesson3.task2;

import java.io.Serializable;

public class ToDoV1 implements Serializable {

    //region Поля
    private String title;
    private boolean isDone;
    //endregion

    //region Конструкторы

    public ToDoV1() {
    }

    public ToDoV1(String title) {
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
}
