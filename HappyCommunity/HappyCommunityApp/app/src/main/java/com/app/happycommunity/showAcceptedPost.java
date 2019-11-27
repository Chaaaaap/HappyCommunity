package com.app.happycommunity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.asynctasks.DeletePostAsyncTask;
import com.app.happycommunity.asynctasks.FetchPostAsyncTask;
import com.app.happycommunity.models.PostOverviewModel;

public class showAcceptedPost extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postpicked);

        String IDString = getIntent().getStringExtra("ID");
        PostOverviewModel post= null;
        final int ID= Integer.parseInt(IDString);
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
        acceptButton.setVisibility(View.GONE);
        declineButton.setText("Back");



        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showAcceptedPost.this, myAcceptedPosts.class);

                startActivity(intent);
                finish();


            }
        });
    }
}
