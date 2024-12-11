package ru.gb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer() {
        while ( !serverSocket.isClosed() ) {
            try {
                Socket socket = serverSocket.accept();
                ClientManger clientManger = new ClientManger( socket );
                System.out.println( "Подключен новый клиент!" );
                Thread thread = new Thread( clientManger );
                thread.start();
            } catch (IOException e) {
                closeSocket();
            }
        }
    }

    private void closeSocket() {
        try {
            if ( serverSocket != null ) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
