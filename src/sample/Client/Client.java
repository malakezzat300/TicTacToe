package sample.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Thread {
    Socket clientSocket;
    DataInputStream dis;
    PrintStream ps;




    public void run() {
        try {
            clientSocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(clientSocket.getInputStream ());
            ps = new PrintStream(clientSocket.getOutputStream ());
            ps.println("");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
            //appendText("clinet : " + replyMsg + "\n");
        } catch(IOException ex){
            ex.printStackTrace();
        } finally{
            try {
                ps.close();
                dis.close();
                clientSocket.close();

            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

}
