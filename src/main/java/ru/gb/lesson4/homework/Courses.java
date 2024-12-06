package ru.gb.lesson4.homework;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "Courses" )
public class Courses {

    private int id;
    private String title;
    private double duration;

    public Courses() {
    }

    public Courses(int id, String title, double duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Courses(int id, String title) {
        this.id = id;
        this.title = title;
        this.duration = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder( this )
                .append( "id", id )
                .append( "title", title )
                .append( "duration", duration )
                .toString();
    }
}
