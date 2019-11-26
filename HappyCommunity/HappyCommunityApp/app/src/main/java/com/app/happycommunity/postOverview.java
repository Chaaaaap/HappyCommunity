package com.app.happycommunity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

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
            if(temp==null){

            }else {
                for(PostOverviewModel model: temp){
                    if(!model.getCreator().equals(MainActivity.Username)) {


                        adapter.add(model);

                    }
            }

            }
        } catch (Exception e) {
               e.printStackTrace();
        }


        postList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                PostOverviewModel post = (PostOverviewModel) adapter.getItemAtPosition(position);
                Intent intent = new Intent(postOverview.this, postPicked.class);
                intent.putExtra("ID",post.getId());

                startActivity(intent);
            }
        });
        final Button createPostButton = (Button) findViewById(R.id.createpostPO);
        final Button profileButton = (Button) findViewById(R.id.profilePO);
        final Button myPostsButton = (Button) findViewById(R.id.mypostsPO);

        myPostsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postOverview.this, myPostOverview.class);

                startActivity(intent);
                finish();

            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postOverview.this, postOverview.class);

                startActivity(intent);
                finish();

            }
        });

        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postOverview.this, createPost.class);

                startActivity(intent);
                finish();

            }
        });

    }


}
