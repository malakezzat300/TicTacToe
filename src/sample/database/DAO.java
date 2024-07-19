package sample.database;

import java.sql.*;

public class DAO {
    Connection con;
    public DAO() throws SQLException {
        try {
             String mycon = "jdbc:mysql://localhost:3306/players";
             con = DriverManager.getConnection(mycon, "root", "root");
        }catch (Exception e) {
            throw e;
               }
    }
    public synchronized void insert(String user, String pass, String email) throws SQLException {
        try {


            con.createStatement().executeLargeUpdate("Insert INTO players VALUES ('"+user+"',"+pass+",'"+email+"',"+0+")");

        }catch (Exception e)
        {
            throw  e;
        }
    }
    public synchronized void addscore(String user) throws Exception {
        try {
            String updateScoreSQL = "UPDATE players SET score = score + 1 WHERE username ='"+user+"'";

            int st=    con.createStatement().executeUpdate(updateScoreSQL);
            if (st==0)throw new Exception("Not found");
        }catch (Exception e)
        {
            throw e;
        }
    }
    public synchronized void checkindatabase(String email,String user) throws Exception {
        try {
            String query = "SELECT COUNT(*) FROM players WHERE email = ? OR username = ?";
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    throw new Exception("email or user exists");
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
    public synchronized void sigup(String name,String pass , String email) throws Exception {
        try {
            checkindatabase(email,name);
            insert(name,pass,email);
        }catch (Exception exception){
            throw exception;
        }
    }
    public synchronized void singin(String name,String pass) throws Exception {
        try {
            check(pass,name);
        }catch (Exception exception){
            throw exception;
        }
    }
    public synchronized void check(String pass,String user) throws Exception {
        try {
            checkuser(user);
            checkpass(pass, user);
        }catch (Exception e){
            throw e;
        }
    }

    private void checkpass(String pass, String user) throws Exception {
        String query2 = "SELECT COUNT(*) FROM players WHERE  username = ? AND password = ?";
        PreparedStatement preparedStatement2= con.prepareStatement(query2);
        preparedStatement2.setString(1, user);
        preparedStatement2.setString(2, pass);
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        // Check if the email and username exist
        if (resultSet2.next()) {
            int count = resultSet2.getInt(1);
            if (count <= 0) {
                throw new Exception("password  is not correct");
            }
        }
    }

    private void checkuser(String user) throws Exception {
        String query = "SELECT COUNT(*) FROM players WHERE  username = ?";
        PreparedStatement preparedStatement= con.prepareStatement(query);
        preparedStatement.setString(1, user);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            if (count <= 0) {
                throw new Exception("username  does not exists");
            }
        }
    }

}
