package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import sample.database.User;

import java.util.ArrayList;

public class types {

        public static String opscore="oscore";
        public static String pscore="pscore";
        public static String data = "data";
        public static  String startGame="startGame";
        public static String Offline="Offline";
        public static String type = "type";
        public static String move = "move";
        public static String RequestToPlay = "RequestToPlay";
        public static String RequestToPlayResponse = "RequestToPlayResponse";
        public  static String UpdateList="UpdateList";
        public static String Error = "Error";
        public static String Message = "Message";
        public static String YouWin = "YouWin";
        public static String EndGame = "EndGame";
        public static String Currentbusy = "Currentbusy";
        public static String CurrentInGame = "CurrentInGame";
        public static String List = "List";
        public static String YouLose = "YouLose";
        public static String SignIn = "SignIn";
        public static String SignUp = "SignUp";
        public static String Email = "Email";
        public static String Password = "Password";
        public static String Username = "Username";
        public static String Opponent = "Opponent";
        public static String Success = "Success";
        public static String Accept = "Accept";
        public static String Refuse = "Refuse";
        public static String point = "point";
        public static String State = "State";

        public static JSONObject createSingin(String username, String password){
            JSONObject object = new JSONObject();
            object.put(types.type,types.SignIn);
            object.put(types.Username,username);
            object.put(types.Password,password);
            return object;
        }

        public static JSONObject createRequestToPlay(String opponent){
            JSONObject object = new JSONObject();
            object.put(types.type,types.RequestToPlay);
            object.put(types.Opponent,opponent);
            return object;
        }
        public static ArrayList<User> updateList(String message){
            JSONObject object = (JSONObject) JSONValue.parse(message);
            JSONArray jsonArray=(JSONArray) JSONValue.parse(object.get(types.List).toString());
            ArrayList<User> users= new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                User user = new User();
                user.name=(String) ((JSONObject)jsonArray.get(i)).get(types.Username);
                Long xe=(Long) ((JSONObject)jsonArray.get(i)).get(types.State);
                user.Status= Math.toIntExact(xe);
                users.add(user);
            }
            System.out.println(users.size());
            return users;
        }
        public static JSONObject createsignup(String name , String password , String email){
            JSONObject object = new JSONObject();
            object.put(types.type,types.SignUp);
            object.put(types.Password,password);
            object.put(types.Email,email);
            object.put(types.Username,name);
            return object;
        }
        public static JSONObject createRequest(String opponent){
            JSONObject object =new JSONObject();
            object.put(types.type,types.RequestToPlay);
            object.put(types.Opponent,opponent);
            return object;
        }
        public static JSONObject responseAccept(){
            JSONObject object =new JSONObject();
            object.put(types.type,types.RequestToPlayResponse);
            object.put(types.Message,types.Accept);
            return object;
        }
        public static JSONObject responseRefuse(){
            JSONObject object =new JSONObject();
            object.put(types.type,types.RequestToPlayResponse);
            object.put(types.Message,types.Refuse);
            return object;
        }
        public static JSONObject sendMove( String move){
            JSONObject object =new JSONObject();
            object.put(types.type,types.move);
            object.put(types.Message,types.move);
            return object;
        }

}
