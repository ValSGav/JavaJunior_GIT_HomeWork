package ru.gb;

import com.mysql.cj.x.protobuf.Mysqlx;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManger implements Runnable {
    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public static ArrayList<ClientManger> clients = new ArrayList<>();

    public ClientManger(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
            bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            name = bufferedReader.readLine();
            clients.add( this );
            System.out.println( name + " подключился(ась) к чату." );
            broadcastMessage( "Server: " + name + " подключился к чату." );
        } catch (IOException e) {
            closeEverything( socket, bufferedReader, bufferedWriter );
        }

    }

    @Override
    public void run() {
        String messageFromClient;
        while ( socket.isConnected() ) {
            try {
                messageFromClient = bufferedReader.readLine();
                broadcastMessage( messageFromClient );
            } catch (IOException e) {
                closeEverything( socket, bufferedReader, bufferedWriter );
                break;
            }

        }
    }

    private void broadcastMessage(String messageFromClient) {
        for (ClientManger client : clients) {
            if ( !client.name.equals( this.name ) ) {
                try {
                    client.bufferedWriter.write( client.name + ": " + messageFromClient );
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                } catch (IOException e) {
                   closeEverything( socket, bufferedReader, bufferedWriter );
                }
            }
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if ( socket != null ) socket.close();
            if ( bufferedReader != null ) bufferedReader.close();
            if ( bufferedWriter != null ) bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        if ( clients.contains( this ) ) {
            clients.remove( this );
            System.out.println( name + " покинул(а) чат." );
            broadcastMessage( "Server: " + name + " покинул чат." );
        }
    }
}
