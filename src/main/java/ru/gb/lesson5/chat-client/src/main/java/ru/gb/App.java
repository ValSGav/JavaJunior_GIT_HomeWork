package ru.gb;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.InetAddress;

public class App {

    private final static String hostName = "localhost";
    private final static int portName = 1400;
    public static void main(String[] args) {
        System.out.println("Start Client...");

        try {
            Scanner scanner = new Scanner( System.in );
            System.out.println( "Введите свое имя: " );

            String name = scanner.nextLine();
            Socket socket = new Socket(hostName, portName);

            InetAddress inetAdress = socket.getInetAddress();
            String remoteIP = inetAdress.getHostAddress();

            System.out.println("Inet adress: " + inetAdress);
            System.out.println("Remote IP: " + remoteIP);
            System.out.println("Local port: " + socket.getLocalPort());

            Client client = new Client(socket, name);
            client.listenForMessage();
            client.sendMessage();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
