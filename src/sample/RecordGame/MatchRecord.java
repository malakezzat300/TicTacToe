package sample.RecordGame;

import sample.RecordUnit;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<RecordUnit> records;
    private String message;
    private String playerOne;
    private String playerTwo;

    public MatchRecord() {
        this.records = new ArrayList<>();
        this.message = " ";
        this.playerOne = "player1";
        this.playerTwo = "player2";
    }

    public ArrayList<RecordUnit> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<RecordUnit> records) {
        this.records = records;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    @Override
    public String toString() {
        return "MatchRecord{" +
                "records=" + records +
                ", message='" + message + '\'' +
                ", playerOne='" + playerOne + '\'' +
                ", playerTwo='" + playerTwo + '\'' +
                '}';
    }
}