package sample.database;

import javafx.concurrent.Task;

import java.io.IOException;
import java.util.ArrayList;

import static sample.database.View.*;

class MyTask extends Task<MainServer> {
    @Override
    protected MainServer call() throws Exception {
        return new MainServer();
    }
}
class MyTask2 extends Task<MainServer> {
    @Override
    protected MainServer call()  {
        while (true){
            updateMessage(offlineCount+" "+onlineCount+" "+inGameCount);
    }}
}



