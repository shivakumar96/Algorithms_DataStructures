package com.shivakumar.algorithms.parctice.design.patterns;

import java.util.HashMap;
import java.util.Map;

//DB service
class DBService{
    private final Map<String,String> users;

    public DBService(){
        users = new HashMap<>();
        users.put("admin_user","admin_password");
        users.put("user_user","user_password");
    }

    public boolean isValidUser(String username){
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password){
        return password.equals(users.get(username));
    }
}

abstract class Handler{
    private Handler next;

    public Handler setNextHandler(Handler next){
        this.next = next;
        return next;
    }
    public abstract boolean handle(String username, String password);

    protected boolean handleNext(String username, String password){
        if(next == null)
            return true;
        return next.handle(username,password);
    }
}


class UserExistHandler extends Handler{
    private DBService db;
    public UserExistHandler(DBService db){
        this.db =db;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!db.isValidUser(username)){
            System.out.println("user not registered");
            return false;
        }
        return handleNext(username,password);
    }
}

class PasswordHandler extends Handler{
    private DBService db;
    public PasswordHandler(DBService db){
        this.db =db;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!db.isValidPassword(username,password)){
            System.out.println("invalid password");
            return false;
        }
        return handleNext(username,password);
    }
}

class RoleCheckHandler extends Handler{

    @Override
    public boolean handle(String username, String password) {
        if ("admin_user".equals(username)){
            System.out.println("Admin Page");
            return true;
        }
        System.out.println("Default Page");
        return handleNext(username,password);
    }
}


class AuthService{
    private  Handler handler;

    public AuthService(Handler handler){
        this.handler = handler;
    }

    public boolean logIn(String email, String password){
        if(handler.handle(email,password)){
            System.out.println("Successful login");

            return  true;
        }
        return false;
    }

}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        DBService db = new DBService();

        Handler handler = new UserExistHandler(db);
        handler.setNextHandler(new PasswordHandler(db))
                .setNextHandler(new RoleCheckHandler());

        AuthService authService = new AuthService(handler);
        authService.logIn("user_user","user_password");
    }
}
