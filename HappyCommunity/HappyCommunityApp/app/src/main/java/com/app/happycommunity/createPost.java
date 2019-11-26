package com.app.happycommunity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.asynctasks.CreatePostAsyncTask;
import com.app.happycommunity.asynctasks.FetchPostsAsyncTask;
import com.app.happycommunity.models.CreatePostModel;
import com.app.happycommunity.models.GlobalData;
import com.app.happycommunity.models.PostOverviewModel;

public class createPost extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Button acceptButton = (Button) findViewById(R.id.acceptBtn);
        Button declineButton = (Button)findViewById(R.id.declineBtn);
        final EditText titel = (EditText) findViewById(R.id.createPostTitle);
       final EditText description = (EditText) findViewById(R.id.createPostDescription);
        final EditText reward = (EditText) findViewById(R.id.createPostReward);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert something in the database

                String newPost = "info?username="+GlobalData.loggedInUser.getUsername()+"&name="+GlobalData.loggedInUser.getName()+"&title="+ titel.getText().toString()+
                        "&description="+description.getText().toString()+"&reward="+reward.getText().toString();
                System.out.println(newPost);
                try {


                    PostOverviewModel temp = new CreatePostAsyncTask().execute(newPost).get();



                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(createPost.this, myPostOverview.class);

                startActivity(intent);
                finish();
            }

        });

        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createPost.this, postOverview.class);

                startActivity(intent);
                finish();


            }
        });
    }
}
