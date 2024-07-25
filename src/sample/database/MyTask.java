package sample.database;

import javafx.concurrent.Task;

import java.util.ArrayList;

import static sample.database.View.*;

class MyTask extends Task<MainServer> {
    @Override
    protected MainServer call() throws Exception {
        return new MainServer();
    }
}

class MyOtherTask extends Task<String> {
    @Override
    protected String call() throws Exception {
        while (true){

            updateMessage(offlines+" "+online+" "+ingame);
        }
    }
}

