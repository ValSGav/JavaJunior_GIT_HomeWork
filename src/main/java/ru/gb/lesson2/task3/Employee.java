package ru.gb.lesson2.task3;

import java.util.UUID;
@Entity
@Table( name = "users" )
public class
Employee {
    private UUID id;
    private String username;
    private String email;
}
