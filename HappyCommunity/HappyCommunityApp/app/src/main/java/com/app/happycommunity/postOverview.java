package com.app.happycommunity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.asynctasks.FetchPostsAsyncTask;
import com.app.happycommunity.models.PostOverviewModel;
import com.app.happycommunity.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class postOverview extends AppCompatActivity{
    ListView postList;
    postOverviewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_view);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        postList=(ListView) findViewById(R.id.postList);
        adapter = new postOverviewAdapter(getApplicationContext());
        postList.setAdapter(adapter);

       ArrayList<PostOverviewModel> temp =  new ArrayList<PostOverviewModel>();
       try {
           temp = new FetchPostsAsyncTask().execute().get();
       } catch (Exception e) {
           e.printStackTrace();
       }
       for(PostOverviewModel model: temp){
           adapter.add(model);
       }

    }



}
