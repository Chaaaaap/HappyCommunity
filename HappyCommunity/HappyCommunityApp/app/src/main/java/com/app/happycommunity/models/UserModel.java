package com.app.happycommunity.models;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class UserModel {
    private String Username;
    private String name;
    private int points;
    private String address;
    private int zipcode;
    private String city;
    private int phoneNumber;
    private int countryCode;

    public UserModel(String username, String name, int points, String address, int zipcode, String city, int phoneNumber, int countryCode) {
        this.Username = username;
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
            this.Username = object.getString("UserName");
            this.name = object.getString("name");
            this.points = object.getInt("points");
            this.address = object.getString("address");
            this.zipcode = object.getInt("zipCode");
            this.city = object.getString("city");
            this.phoneNumber = object.getInt("phoneNumber");
            this.countryCode = object.getInt("countryCode");
        } catch(JSONException e) {
            e.printStackTrace();
            Log.d("DEBUG: ", e.getMessage());
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setZipcode(int zipCode) {
        this.zipcode = zipCode;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getUsername() {
        return this.Username;
    }
    public String getName() {
        return this.name;
    }
    public int getPoints() {
        return this.points;
    }
    public String getAddress() {
        return this.address;
    }
    public int getZipcode() {
        return this.zipcode;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

}
