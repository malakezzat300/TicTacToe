package sample.NetworkPackge;

import org.json.simple.JSONObject;
import sample.NetworkPackge.ClientSocket;
import sample.SignUpPage.Types;

public class Network {

    String ConvertedJson;
    ClientSocket client = ClientSocket.getInstance();

    // sign Up
    public void signUp(String userName, String email, String password) {

        if (userName == null || email == null || password == null ) {
            throw new IllegalArgumentException("Arguments must not be null");
        }
        JSONObject jsonToSendData = new JSONObject();
        jsonToSendData.put(Types.type, Types.SignUp);
        jsonToSendData.put(Types.Username,userName);
        jsonToSendData.put(Types.Email,email);
        jsonToSendData.put(Types.Password,password);
        ConvertedJson = jsonToSendData.toString(); // convert json to String
        client.sendToServer(ConvertedJson);         // send json after convert

    }
    //***************************************************
    // Sign in
    public void signIn(String email,String password){
        if (email == null || password == null){
            throw new IllegalArgumentException("arguments must not be Null");
        }
        JSONObject jsonToSendData = new JSONObject();
        jsonToSendData.put(Types.type,Types.SignIn);
        jsonToSendData.put(Types.Email,email);
        jsonToSendData.put(Types.Password,password);
        ConvertedJson = jsonToSendData.toString(); // convert json to String
        client.sendToServer(ConvertedJson);         // send json after convert

    }
    //**************************************************
    // request to RequestToPlay game
    public void RequestToPlay(String opponentID){
        JSONObject jsonToSendData = new JSONObject();
        jsonToSendData.put(Types.type,Types.RequestToPlay);
        ConvertedJson = jsonToSendData.toString(); // convert json to String
        client.sendToServer(ConvertedJson);         // send json after convert

    }
    //*******************************************
/*    // request to show player list

    public void sentToGetPlayerList(){

        JSONObject jsonToSendData = new JSONObject();
        jsonToSendData.put(Types.type,Types.UpdateList);
        ConvertedJson = jsonToSendData.toString(); // convert json to String
        client.sendToServer(ConvertedJson);         // send json after convert
    }*/



    //*******************************************

}


