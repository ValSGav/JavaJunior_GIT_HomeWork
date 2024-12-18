package ru.gb;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private final String name;

    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    public Client(Socket socket, String userName) {
        this.socket = socket;
        this.name = userName;
        try {
            bufferedWriter = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
            bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        } catch (IOException e) {
            closeEverything( socket, bufferedReader, bufferedWriter );
            throw new RuntimeException( e );
        }
    }

    public void listenForMessage() {
        new Thread(() -> {
            String message;
            while ( socket.isConnected() ) {
                try {
                    message = bufferedReader.readLine();
                    System.out.println( message );
                } catch (IOException e) {
                    System.out.println("ошибка");
                    closeEverything( socket, bufferedReader, bufferedWriter );
                    break;
                }
            }
        }).start();
    }

    public void sendMessage() {
        try {
            bufferedWriter.write( name );
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner sc = new Scanner( System.in );
            while ( socket.isConnected() ){
                String message = sc.nextLine();
                bufferedWriter.write(  message );
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything( socket, bufferedReader, bufferedWriter );
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if ( bufferedReader != null ) bufferedReader.close();
            if ( bufferedWriter != null ) bufferedWriter.close();
            if ( socket != null ) socket.close();
        } catch (IOException e) {
            throw new RuntimeException( e );
        }
    }
}
