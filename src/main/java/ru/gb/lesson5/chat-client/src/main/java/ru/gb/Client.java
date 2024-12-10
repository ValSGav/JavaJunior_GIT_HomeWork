package ru.gb;

import java.io.*;
import java.net.Socket;

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
