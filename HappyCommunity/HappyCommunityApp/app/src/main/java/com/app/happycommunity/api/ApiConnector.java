package com.app.happycommunity.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ApiConnector {
    private static final String BASE_URL = "http://10.0.2.2/api/";

    private static StringBuffer get(String requestUrl) throws Exception {
        try {
            URL url = new URL(BASE_URL + requestUrl);
            StringBuffer data = new StringBuffer(1024);
            URLConnection conn = url.openConnection();

            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String tmp = "";

                while((tmp = buffer.readLine()) != null) {
                    data.append(tmp).append("\n");
                }
            }
            return data;

        } catch(IOException e) {
            throw new Exception("Something went wrong... Oops!");
        }

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
            JSONArray json = new JSONArray(data.toString());

            return json.getJSONObject(json.length() - 1);
        } catch (Exception e)
        {
            throw e;
        }
    }
}
