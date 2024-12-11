package ru.gb;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class ClientManger implements Runnable {
    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public static ArrayList<ClientManger> clients = new ArrayList<>();

    //region homework
    private void broadcastMessage(String messageFromClient) {
        for (ClientManger client : clients) {
            if (!client.name.equals(this.name)) {
                sendMessage(client, messageFromClient);
            }
        }
    }

    private void broadcastMessage(String messageFromClient, String clientName) {
        for (ClientManger client : clients) {
            if (client.name.equals(clientName)) {
                sendMessage(client, messageFromClient);
            }
        }
    }

    private void sendMessage(ClientManger client, String messageFromClient) {
        try {
            client.bufferedWriter.write(messageFromClient);
            client.bufferedWriter.newLine();
            client.bufferedWriter.flush();
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    //endregion


    public ClientManger(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " подключился(ась) к чату.");
            broadcastMessage("Server: " + name + " подключился к чату.");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = this.name + ": " + bufferedReader.readLine();
                String[] partsOfMessage = messageFromClient.split(" ");
                String nameOfPrivateClient = "";
                StringBuilder formattedMessageFromClient = new StringBuilder();
                for (String part : partsOfMessage) {
                    if (part.startsWith("@"))
                        nameOfPrivateClient = part.substring(1, part.length()).toString();
                    else
                        formattedMessageFromClient.append(part).append(" ");
                }
                if (formattedMessageFromClient.length() > 0)
                    formattedMessageFromClient
                            .deleteCharAt(formattedMessageFromClient.length() - 1);

                if (nameOfPrivateClient == "")
                    broadcastMessage(formattedMessageFromClient.toString());
                else
                    broadcastMessage(formattedMessageFromClient.toString(), nameOfPrivateClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }

        }
    }



    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (socket != null) socket.close();
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        if (clients.contains(this)) {
            clients.remove(this);
            System.out.println(name + " покинул(а) чат.");
            broadcastMessage("Server: " + name + " покинул чат.");
        }
    }
}
