package sample.NetworkPackge;

import org.json.simple.JSONObject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket  extends  Thread{
    public static String myMesage;
    private Socket clientSocket ;
    private DataInputStream dataIn;
    private static DataOutputStream dataout;
    private String jasonToText ;
    private JSONObject jsonObject ;
    private boolean isConnected;
    private String ipAddress = "";
    private final int portNumber = 8000;

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
    public static void sendToServer(String messageType){

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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


