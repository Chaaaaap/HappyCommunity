package com.app.happycommunity.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class CreatePostModel {
    private long id;
    private String title;
    private int reward;
    private String creator;
    private String city;
    private String description;
    private String username;

    public CreatePostModel(String username, String description, String title, int reward, String creator, String city) {
        this.id = id;
        this.title = title;
        this.reward = reward;
        this.creator = creator;
        this.city = city;
        this.username=username;
        this.description=description;
    }
    public CreatePostModel(JSONObject object) {
        try {
            this.id = object.getLong("id");
            this.title = object.getString("title");
            this.reward = object.getInt("reward");
            this.creator = object.getString("name");
            this.city = object.getString("city");

            this.username =object.getString("userName");
            this.description = object.getString("description");
        } catch(JSONException e) {
            e.printStackTrace();
            Log.d("DEBUG: ", e.getMessage());
            e.printStackTrace();
        }
    }
    public String getDescription(){return this.description;}
    public long getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public int getReward() {
        return this.reward;
    }
    public String getCreator() {
        return this.creator;
    }
    public String getCity() {
        return this.city;
    }
    public String getUsername(){return this.username;}

    public void setTitle(String title) {
        this.title = title;
    }
    public void setReward(int reward) {
        this.reward = reward;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setDescription (String description) {this.description=description;}
    public void setUsername(String username) {this.username=username;}
}
