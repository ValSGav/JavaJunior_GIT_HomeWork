package ru.gb.lesson3.task1;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData userData = new UserData( "Andrew", 23, "12345" );

        try (FileOutputStream fileOutputStream = new FileOutputStream( "userdata.bin" )) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );
            objectOutputStream.writeObject( userData );
            System.out.println(userData);
            System.out.println( "Объект UserData сериализован!" );
        }

        try (FileInputStream fileInputStream = new FileInputStream( "userdata.bin" )) {
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );
            userData = (UserData) objectInputStream.readObject();
            System.out.println( "Объект UserData  десериализован!" );
            System.out.println(userData);
        } ;

    }
}


