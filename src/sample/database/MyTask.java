package sample.database;

import javafx.concurrent.Task;

import java.util.ArrayList;

class MyTask extends Task<MainServer> {
    @Override
    protected MainServer call() throws Exception {
        return new MainServer();
    }
}

class MyOtherTask extends Task<ArrayList<Integer>> {
    @Override
    protected ArrayList<Integer> call() throws Exception {
        while (true){


        }
    }
}

