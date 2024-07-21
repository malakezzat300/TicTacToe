package sample.database;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer extends  Thread{
    ServerSocket serverSocket = new ServerSocket(8000);

    public MainServer() throws IOException {
        start();
    }
    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                if (!serverSocket.isClosed())
                  new Server(serverSocket);
            } catch (IOException e) {
                break;
            }
        }
    }
}
