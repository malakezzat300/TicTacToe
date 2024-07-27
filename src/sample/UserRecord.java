package sample;

import java.io.Serializable;

public class UserRecord implements Serializable {
    private int pscore;
    private String Username;
    private int State;
    protected final static String OFFLINE = "offline";
    protected final static String ONLINE = "online";
    protected final static String REQUEST = "request";
    protected final static String INGAME = "inGame";

    public UserRecord(int pscore, String username, int state) {
        this.pscore = pscore;
        this.Username = username;
        this.State = state;
    }

    public int getPscore() {
        return pscore;
    }

    public void setPscore(int pscore) {
        this.pscore = pscore;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getState() {
        if(State == -1){
            return OFFLINE;
        } else if(State == 0){
            return ONLINE;
        } else if(State == 1){
            return REQUEST;
        } else if(State == 2){
            return INGAME;
        } else {
            return  " ";
        }
    }

    public void setState(int state) {
        State = state;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
                "pscore=" + pscore +
                ", Username='" + Username + '\'' +
                ", State=" + State +
                '}';
    }
}
