package sample.database;


import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static sample.database.Main.dao;
import static sample.database.View.stringProperty2;

class Server extends Thread {
    NetWork netWork=new NetWork(dao,this);
    private Socket socket;
    public DataInputStream dataInputStream;
    public DataOutputStream dataOutputStream;
    private ServerSocket serverSocket;
    User user=new User();
    public String player2;
    public Server(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        if (!serverSocket.isClosed()) {
            System.out.println("Server is starting...");
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            start();
        }
    }

    @Override
    public void run() {
        super.run();
        while (!socket.isClosed()&&socket.isConnected()) {
            try {
                netWork.start();
            } catch (Exception e) {
                Platform.runLater(() -> updateUIForUser(user.name, 0));
                if (user.Status==2)
                {
                    try {
                        netWork.sendwinng();
                    } catch (IOException ioException) {
                        System.out.println(ioException.getMessage());
                    }
                }
                MainServer.servers.remove(this);
                try {
                    NetWork.sendlistplayer();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                closeConnections();
                interrupt();
                break; // Exit the loop if there's an error
            }
        }
    }



    private void updateUIForUser(String username, int status) {
        Platform.runLater(() -> {
            for (User user : stringProperty2) {
                if (user.name.equals(username)) {
                    user.Status = status;
                    stringProperty2.set(stringProperty2.indexOf(user), user); // Trigger ListView update
                    break;
                }
            }
        });
    }

    private void closeConnections() {
        try {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}