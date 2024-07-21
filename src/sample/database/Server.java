package sample.database;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static sample.database.Main.dao;

public class Server extends Thread {
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    ServerSocket serverSocket;
    public Server(ServerSocket serverSocket) throws IOException {
        this.serverSocket=serverSocket;
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
                String message = dataInputStream.readUTF();
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(message);

                String userType = (String) jsonObject.get("UserType");
                if (userType.equals("1")){
                    String username = (String) jsonObject.get("UserName");
                    String email = (String) jsonObject.get("Email");
                    String password = (String) jsonObject.get("Password");
                    System.out.println(username + " " + email + " " + password + " " + userType);
                    dao.sigup(username, password, email);
                    dataOutputStream.writeUTF("1");
                }else if (userType.equals("2")){

                    String username = (String) jsonObject.get("UserName");
                    String password = (String) jsonObject.get("Password");
                    dao.singin(username, password);
                    dataOutputStream.writeUTF("1");
                }

            } catch (Exception e) {
                e.printStackTrace();
                closeConnections();
                break; // Exit the loop if there's an error
            }
        }
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
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
