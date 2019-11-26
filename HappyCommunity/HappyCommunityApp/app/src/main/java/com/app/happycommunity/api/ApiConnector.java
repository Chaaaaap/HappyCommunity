package com.app.happycommunity.api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static android.content.ContentValues.TAG;

public class ApiConnector {
    private static final String BASE_URL = "http://10.0.2.2:50104/api/";

    private static StringBuffer get(String requestUrl) throws Exception {
        try {
            URL url = new URL(BASE_URL + requestUrl);
            StringBuffer data = new StringBuffer(1024);
            URLConnection conn = url.openConnection();

            try {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String tmp = "";

                while((tmp = buffer.readLine()) != null) {
                    data.append(tmp).append("\n");
                }
            } catch (IOException e) {
                throw e;
            }
            return data;

        } catch(IOException e) {
            e.printStackTrace();
            Log.d(TAG, "get: " + e.getMessage());
        }
        return null;
    }

    public static JSONArray getJSONArray(String url) throws Exception{
        try {
            StringBuffer data = get(url);
            return new JSONArray(data.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    public static JSONObject getObject(String url) throws Exception {
        try
        {
            StringBuffer data = get(url);
            try {
                JSONArray json = new JSONArray(data.toString());
                return json.getJSONObject(json.length() - 1);
            } catch (JSONException e) {
                return new JSONObject((data.toString()));
            }

        } catch (Exception e)
        {
            throw e;
        }
    }
}
