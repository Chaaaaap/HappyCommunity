package com.app.happycommunity.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class UserModel {
    private long id;
    private String name;
    private int points;
    private String address;
    private int zipcode;
    private String city;
    private int phoneNumber;
    private int countryCode;

    public UserModel(long id, String name, int points, String address, int zipcode, String city, int phoneNumber, int countryCode) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
    }

    public UserModel(JSONObject object) {
        try {
            this.id = object.getLong("id");
            this.name = object.getString("name");
            this.points = object.getInt("points");
            this.address = object.getString("address");
            this.zipcode = object.getInt("zipcode");
            this.city = object.getString("city");
            this.phoneNumber = object.getInt("phoneNumber");
            this.countryCode = object.getInt("countryCode");
        } catch(JSONException e) {
            e.printStackTrace();
            Log.d("DEBUG: ", e.getMessage());
        }
    }
}
