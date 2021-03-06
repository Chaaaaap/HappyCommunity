package com.app.happycommunity.api;

import com.app.happycommunity.models.PostOverviewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiPosts {

    public static ArrayList<PostOverviewModel> getPosts(String id) {
        String url = "getposts/"+id;
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
    public static PostOverviewModel getPost(Integer id) {
        String url = "getpost/"+id;

        try {
            JSONObject object = ApiConnector.getObject(url);



            PostOverviewModel post =(new PostOverviewModel(object));

            return post;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static PostOverviewModel makePost(String id) {
        String url = "createpost/"+id;
        try {
            JSONObject object = ApiConnector.getObject(url);



            PostOverviewModel post =(new PostOverviewModel(object));

            return post;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static PostOverviewModel deletePost(int id) {
        String url = "deletePost/"+id;
        try {
            JSONObject object = ApiConnector.getObject(url);



            PostOverviewModel post =(new PostOverviewModel(object));

            return post;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static PostOverviewModel createUser(String id) {
        String url = "createuser/" + id;
        try {
            JSONObject object = ApiConnector.getObject(url);


            PostOverviewModel post = (new PostOverviewModel(object));

            return post;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static PostOverviewModel createGeneral(String url) {

        try {
            JSONObject object = ApiConnector.getObject(url);


            PostOverviewModel post = (new PostOverviewModel(object));

            return post;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<PostOverviewModel> getAcceptedPosts(String id) {
        String url = "getmytasks/"+id;
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
