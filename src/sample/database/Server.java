package sample.database;

import javafx.application.Platform;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static sample.database.Main.dao;
import static sample.database.View.stringProperty2;

 class Server extends Thread {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private ServerSocket serverSocket;
    public String username;
    public String player2;
    public boolean isplaying;

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
                String message = dataInputStream.readUTF();
                if (message.isEmpty()) continue;
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(message);
                String userType = (String) jsonObject.get("UserType");
                if (userType.equals("1")) {
                    Signup(jsonObject);
                } else if (userType.equals("2")) {
                    Signin(jsonObject);
                }
            } catch (Exception e) {
                Platform.runLater(() -> updateUIForUser(username, false));
                closeConnections();
                interrupt();
                break; // Exit the loop if there's an error
            }
        }
    }

    private void Signin(JSONObject jsonObject) throws Exception {
        try {
            username = (String) jsonObject.get("UserName");
            String password = (String) jsonObject.get("Password");
            dao.signin(username, password);
            dataOutputStream.writeUTF("1");
            dataOutputStream.flush();
            Platform.runLater(() -> updateUIForUser(username, true));

        }catch (Exception e){
            dataOutputStream.writeUTF("2");

        }

    }

    private void Signup(JSONObject jsonObject) throws Exception {
     try {   username = (String) jsonObject.get("UserName");
        String email = (String) jsonObject.get("Email");
        String password = (String) jsonObject.get("Password");
        dao.signup(username, password, email);
        dataOutputStream.writeUTF("1");

    }catch (Exception e){
        dataOutputStream.writeUTF("2");

    }
    }

    private void updateUIForUser(String username, boolean status) {
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
