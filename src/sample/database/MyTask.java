package sample.database;

import javafx.concurrent.Task;

 class MyTask extends Task<MainServer> {
    @Override
    protected MainServer call() throws Exception {
        return new MainServer();
    }
}
