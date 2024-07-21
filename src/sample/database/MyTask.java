package sample.database;

import javafx.concurrent.Task;

public class MyTask extends Task<MainServer> {
    @Override
    protected MainServer call() throws Exception {
        return new MainServer();
    }
}
