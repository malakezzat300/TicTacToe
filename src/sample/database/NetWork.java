package sample.database;

import com.mysql.cj.xdevapi.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import sample.SignUpPage.Types;

import static sample.database.MainServer.servers;
import static sample.database.MainServer.size;
import static sample.database.View.*;
import static sample.types.withdraw;

import sample.types;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

 class NetWork {
    DAO dao;
    Server server;
    public NetWork(DAO dao,Server server){
        this.server=server;
        this.dao=dao;
    }

    public void start() throws Exception {
           JSONObject object1;
            String message=server.dataInputStream.readUTF();
            object1=(JSONObject) JSONValue.parse(message);

        if (types.SignIn.equals(object1.get(types.type))) {
            RequestSignIng(object1);
        }else if(Types.RequestToPlay.equals(object1.get(Types.type))){
            RequestToPlay(object1); }
        else if(Types.RequestToPlayResponse.equals(object1.get(Types.type))){
            ResposeToPlay(object1);
        }
        else if(Types.SignUp.equals(object1.get(Types.type))){
            RequesSignUp(object1);
        }

    }
    public void RequesSignUp(JSONObject object) throws IOException {
        try {
            String name=  (String) object.get(Types.Username);
            String email=  (String) object.get(Types.Email);
            String pass=  (String) object.get(Types.Password);
            dao.signup(name,pass,email);
            object=new JSONObject();
            object.put(Types.type,Types.Success);
            server.dataOutputStream.writeUTF(object.toString());
        }catch (Exception e){
            ErrorRespose(e);
        }
    }
    public void RequestSignIng(JSONObject object) throws Exception{
        try {
            String Name=(String) object.get(Types.Username);
            String PassWord=(String) object.get(Types.Password);
            dao.signin(Name,PassWord);
           for (int i = 0; i < servers.size(); i++) {
                if (servers.get(i).user.name.equals(Name)){
                    throw  new Exception("user already exists");
                }
            }
            this.server.user.name=Name;
            servers.add(server);
            System.out.println(" name login "+server.user.name);
            JSONObject object1= new JSONObject();
            object1.put(Types.type,Types.Success);
            server.dataOutputStream.writeUTF(object1.toString());
            System.out.println(servers.size());
            NetWork.sendlistplayer();
           onlineCount+=1;
           offlineCount-=1;

        }catch (Exception e){
            ErrorRespose(e);
        }
    }
    public void RequestSignUp(JSONObject object) throws Exception{
        try {
            String Name=(String) object.get(Types.Username);
            String Email=(String) object.get(Types.Email);
            String PassWord=(String) object.get(Types.Password);
            dao.signup(Name,PassWord,Email);
            offlineCount+=1;
        }catch (Exception e){
            ErrorRespose(e);
        }
    }
    public void ErrorRespose(Exception e) throws IOException {
        JSONObject object=new JSONObject();
        object.put(Types.type,Types.Error);
        object.put(Types.Message,e.getMessage());
        server.dataOutputStream.writeUTF(object.toString());
    }
    public void RequestToPlay(JSONObject object) throws Exception {
        String Opponent=(String)  object.get(types.Opponent);
        server.user.Oppentment=(String) object.get(types.Opponent);
        server.user.Status=1;
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).user.name .equals(Opponent)){
                if (servers.get(i).user.Status==1){
                    object = responseBusy(Types.Currentbusy);
                    server.user.Status=0;
                    server.user.Oppentment=null;
                    server.dataOutputStream.writeUTF(object.toString());
                    return;
                }else if (servers.get(i).user.Status==2){
                     object = responseBusy(Types.CurrentInGame);
                     server.user.Status=0;
                     server.user.Oppentment=null;
                     server.dataOutputStream.writeUTF(object.toString());
                    return;
                }else if (servers.get(i).user.Status==0){
                    JSONObject object1 = new JSONObject();
                    server.user.Oppentment=servers.get(i).user.name;
                    object1.put(Types.type, Types.RequestToPlay);
                    servers.get(i).user.Status = 1;
                    servers.get(i).user.Oppentment= server.user.name;
                    object1.put(Types.Opponent, server.user.name);
                    servers.get(i).dataOutputStream.writeUTF(object1.toString());
                    sendlistplayer();
                    return;
                }
            }
        }
         object = responseBusy(Types.Offline);
        server.user.Status=0;
        server.user.Oppentment=null;
        server.dataOutputStream.writeUTF(object.toString());
    }

    private JSONObject responseBusy(String currentbusy) {
        JSONObject object;
        object = new JSONObject();
        object.put(Types.type, Types.RequestToPlayResponse);
        object.put(Types.Message, currentbusy);
        return object;
    }


    public static synchronized   void  sendlistplayer()throws Exception{
        System.out.println("users in server"+servers.size());
        for (int i = 0; i < servers.size(); i++) {
            JSONArray array = new JSONArray();
            for (int j = 0; j < servers.size(); j++) {
                if (i == j) continue;
                JSONObject object = new JSONObject();
                object.put(types.Username, servers.get(j).user.name);
                object.put(types.State, servers.get(j).user.Status);
                array.add(object);
            }
            System.out.println(" updated for  " + servers.get(i).user.name);
            JSONObject object2 = new JSONObject();
            if (servers.size() > 1) {
                try {
                    object2.put(types.type, types.UpdateList);
                    object2.put(types.List, array);
                    servers.get(i).dataOutputStream.writeUTF(object2.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public  void  ResposeToPlay(JSONObject object) throws Exception {
        String Opponent=(String)object.get(types.Message);
        String player1= server.user.Oppentment;
        for (int i = 0; i < servers.size(); i++) {
            String plyer2=servers.get(i).user.name;
            if (servers.get(i).user.name.equals(server.user.Oppentment)){
                if (object.get(Types.Message).equals(Types.Accept)){
                    server.user.Status=2;
                    servers.get(i).user.Oppentment=server.user.name;
                    servers.get(i).user.name=server.user.Oppentment;
                    servers.get(i).user.Status=2;
                }else {
                    server.user.Oppentment=null;
                    server.user.Status=0;
                    servers.get(i).user.Oppentment=null;
                    servers.get(i).user.Status=0;
                }
                servers.get(i).dataOutputStream.writeUTF(object.toString());
                sendlistplayer();
                return;
            }
        }
    }
    public void sendwinng(String winner,String loser) throws IOException {
        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).user.name .equals(winner)){
                JSONObject object = new JSONObject();
                object.put(Types.type,Types.EndGame);
                object.put(Types.Message,Types.YouWin);
                servers.get(i).user.Oppentment=null;
                servers.get(i).user.Status=0;
                try {
                    dao.addscore(server.user.name);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                servers.get(i).dataOutputStream.writeUTF(object.toString());
            }
            if (servers.get(i).user.name .equals(loser)){
                JSONObject object = new JSONObject();
                object.put(Types.type,Types.EndGame);
                object.put(Types.Message,Types.YouLose);
                servers.get(i).user.Oppentment=null;
                servers.get(i).user.Status=0;
                servers.get(i).dataOutputStream.writeUTF(object.toString());
            }
            }

    }

    public void RequestToMove(JSONObject object){
        String point =(String) object.get(Types.point);

    }
}