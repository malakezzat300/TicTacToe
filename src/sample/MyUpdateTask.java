package sample;

import javafx.concurrent.Task;
import sample.NetworkPackge.ClientSocket;
import static sample.NetworkPackge.ClientSocket.ss;
import java.util.Random;

public class MyUpdateTask extends Task<String> {
    @Override
    protected String call() throws Exception {
        while (true){


                        updateMessage(ss+ "");

        }
    }
}
