package sample.SignUpPage;
import org.json.simple.JSONObject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class AuthenticateSignUp implements Runnable {

    private JSONObject signUpObject;
    private Socket client;              // client Socket
    private DataInputStream inMsg;     // data input
    private DataOutputStream outMsg; // Use data output message for sending text data
    private  String jsonText;        // to add jason as text
    private String userCase = "0"; // case of user that come from Server


    // Constructor to initialize and start the thread
    public AuthenticateSignUp(String userName, String email, String password,String userType) {
        // Ensure other initializations are done here
        if (userName == null || email == null || password == null || userType == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        signUpObject= new JSONObject();

    /*    signUpObject.put("UserName", userName);
        signUpObject.put("Email", email);
        signUpObject.put("Password", password);
        signUpObject.put("UserType", userType);*/

        signUpObject.put(Types.type,Types.SignUp);
        signUpObject.put(Types.Username,userName) ;
        signUpObject.put(Types.Email,email) ;
        signUpObject.put(Types.Password,password) ;

        // Convert JSON to string
        jsonText = signUpObject.toString();
        // Initialize socket connection and start the thread
        try {
            client = new Socket("10.145.18.10", 8000);
            outMsg = new DataOutputStream(client.getOutputStream()); // Auto-flush enabled
            inMsg = new DataInputStream(client.getInputStream());

            Thread thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Getter for userCase
    public String getUserCase() {
        return userCase;
    }

    // Method to send data
    public void sendSignUpData() {
        if (outMsg != null) {
            try {
                outMsg.writeUTF(jsonText); // Send JSON data to the server

            }catch (Exception e){
                System.out.println("No Data Sent error on outMsg");
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            sendSignUpData(); // Send data as soon as the thread starts

            // Continuously read responses from the server
            try {

                String message;
                while ((message = inMsg.readUTF()) != null) { // Read UTF-8 encoded strings
                    userCase = message;
                    System.out.println(message);    // Process the response
                    System.out.println("Received from server: " + userCase);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Failed to read data", e);


            } finally {
                // Close resources
                try {
                    if (inMsg != null) inMsg.close();
                    if (outMsg != null) outMsg.close();
                    if (client != null) client.close();
                } catch (IOException e) {

                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
