package sample.database;

import java.io.IOException;
import java.net.ServerSocket;

 class MainServer extends  Thread{
   public    ServerSocket  serverSocket;

    public MainServer() throws IOException {
        serverSocket = new ServerSocket(8000);
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
