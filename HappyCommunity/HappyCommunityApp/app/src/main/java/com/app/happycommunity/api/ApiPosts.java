package com.app.happycommunity.api;

import com.app.happycommunity.models.PostOverviewModel;

import org.json.JSONArray;

import java.util.ArrayList;

public class ApiPosts {

    public static ArrayList<PostOverviewModel> getPosts() {
        String url = "getposts";
        ArrayList<PostOverviewModel> posts = new ArrayList<>();

        try {
            JSONArray array = ApiConnector.getJSONArray(url);


            for(int i = 0; i < array.length(); i++) {
                posts.add(new PostOverviewModel(array.getJSONObject(i)));
            }
            return posts;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
}
