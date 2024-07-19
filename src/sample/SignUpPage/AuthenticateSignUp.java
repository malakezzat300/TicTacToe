package sample.SignUpPage;

import org.json.simple.JSONObject;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthenticateSignUp implements Runnable {

    private  JSONObject signUpObject;
    private Socket client;
    private DataInputStream inMsg;
    private PrintWriter outMsg; // Use PrintWriter for sending text data
    private String jsonText;
    private String userCase = "2";

    // Constructor to initialize and start the thread
    public AuthenticateSignUp(String userName, String email, String password) {
        signUpObject = new JSONObject();
        signUpObject.put("UserName", userName);
        signUpObject.put("Email", email);
        signUpObject.put("Password", password);

        // Convert JSON to string
        jsonText = signUpObject.toJSONString();

        // Initialize socket connection and start the thread
        try {
            client = new Socket("127.0.0.1", 5005);
            outMsg = new PrintWriter(client.getOutputStream(), true); // Auto-flush enabled
            Thread thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create socket or output stream", e);
        }
    }

    // Getter for userCase
    public String getUserCase() {
        return userCase;
    }

    // Method to send data
    public void sendSignUpData() {
        if (outMsg != null) {
            outMsg.println(jsonText); // Send JSON data to the server
        }
    }

    @Override
    public void run() {
        sendSignUpData(); // Send data as soon as the thread starts

        // Continuously read responses from the server
        try {
            inMsg = new DataInputStream(client.getInputStream());
            String message;
            while ((message = inMsg.readUTF()) != null) { // Read UTF-8 encoded strings
                userCase = message; // Process the response
                System.out.println("Received from server: " + userCase);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read data", e);
        } finally {
            // Close resources
            try {
                if (inMsg != null) inMsg.close();
                if (outMsg != null) outMsg.close();
                if (client != null) client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

