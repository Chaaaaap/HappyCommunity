package com.app.happycommunity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.api.ApiConnector;
import com.app.happycommunity.asynctasks.CreateGeneralAsyncTask;
import com.app.happycommunity.asynctasks.CreatePostAsyncTask;
import com.app.happycommunity.asynctasks.FetchPostAsyncTask;
import com.app.happycommunity.models.GlobalData;
import com.app.happycommunity.models.PostOverviewModel;

import org.json.JSONArray;

public class postPicked extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postpicked);
        String IDString = getIntent().getStringExtra("ID");
        PostOverviewModel post= null;
       final int ID= Integer.parseInt(IDString);
        System.out.println(ID);
        try {
        post = new FetchPostAsyncTask().execute(ID).get();


        } catch(Exception e) {
            e.printStackTrace();
        }


        TextView textViewCreator = (TextView) findViewById(R.id.pPCreator);
        TextView textViewTitle = (TextView) findViewById(R.id.titlePP);
        TextView textViewReward = (TextView) findViewById(R.id.rewardPP);
        TextView textViewDescription = (TextView) findViewById(R.id.pPDescription);
        textViewCreator.setText(post.getCreator());
        textViewReward.setText(post.getReward()+"");
        textViewTitle.setText(post.getTitle());
        textViewDescription.setText(post.getDescription());

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Button acceptButton = (Button) findViewById(R.id.acceptBtn);
        Button declineButton = (Button)findViewById(R.id.declineBtn);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String takenPost = "takepost/info?username="+ GlobalData.loggedInUser.getUsername()+"&postid="+ID;

                try {


                    new CreateGeneralAsyncTask().execute(takenPost).get();



                } catch (Exception e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(postPicked.this, postOverview.class);

                startActivity(intent);
                finish();

            }
        });
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(postPicked.this, postOverview.class);

                startActivity(intent);
                finish();


            }
        });
    }
}
