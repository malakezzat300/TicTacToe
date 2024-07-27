package sample.NetworkPackge;

import javafx.scene.Parent;
import javafx.scene.Scene;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sample.SettingsScreenBase;

import java.io.*;
import java.net.Socket;
import java.text.ParseException;

public class ClientSocket  extends  Thread{
    private static volatile ClientSocket instance;
    public static String myMesage;
    private Socket clientSocket ;
    private DataInputStream dataIn;
    private static DataOutputStream dataout;
    private String jasonToText ;
    private JSONObject jsonObject ;
    private boolean isConnected;
    private String ipAddress = "10.241.12.166";
    private final int portNumber = 8000;
    public static final int LOGIN = 1;
    public static final int SIGNUP = 2;
    private boolean success;
    private String errorMessage;
    public static int mode;

    private ClientSocket() {
        // Private constructor to prevent instantiation
    }

    public static ClientSocket getInstance() {
        if (instance == null) {
            synchronized (ClientSocket.class) {
                if (instance == null) {
                    instance = new ClientSocket();
                }
            }
        }
        return instance;
    }


    //**************************************************

    public void setIpAddress(String ipAddress){

        this.ipAddress = ipAddress;
    }

    //**************************************

    public void connectClient(){

        if (!isConnected){
            try {
                clientSocket = new Socket(ipAddress,portNumber);
                dataIn = new DataInputStream(clientSocket.getInputStream());
                dataout = new DataOutputStream(clientSocket.getOutputStream());
                isConnected = true;
                this.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //**********************************************

    // close connection
    public void closeConnections() {
        try {
            if (dataIn != null) {
                dataIn.close();
            }
            if (dataout != null) {
                dataout.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // **********************************************
    // send To Server
    public static void sendToServer(String messageType,int mode){
        ClientSocket.mode = mode;
        String message = messageType;
        try {
            dataout.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // ***************************;
    @Override
    public void run(){
        while (true){

            try {
                myMesage = dataIn.readUTF();
                handleMessage(myMesage);
            } catch (IOException e) {
               break;
            }
        }

    }

    public String getMesage(){
        return myMesage;
    }


    private void handleMessage(String message) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new StringReader(message));
            String type = (String) jsonObject.get("type");

            if ("Success".equals(type)) {
                success = true;
                handleSuccessMessage(jsonObject);
            } else if ("Error".equals(type)) {
                success = false;
                handleErrorMessage(jsonObject);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleSuccessMessage(JSONObject jsonObject) {
        System.out.println("Success: " + jsonObject);
    }

    private void handleErrorMessage(JSONObject jsonObject) {
        errorMessage = (String) jsonObject.get("Message");
        // Handle error message
        System.out.println("Error: " + errorMessage);
    }

    public boolean isSuccess(){
        return success;
    }

    public String getError() {
        return errorMessage;
    }
}


