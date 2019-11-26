package com.app.happycommunity.api;

import com.app.happycommunity.models.LoginInfo;
import com.app.happycommunity.models.UserModel;

import org.json.JSONObject;

public class ApiUsers {
    public static UserModel Login(LoginInfo login) {
        String url = "login/info?username="+login.getUsername()+"&password="+login.getPassword();
        UserModel user = null;
        try {
            JSONObject object = ApiConnector.getObject(url);
            user = new UserModel(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
