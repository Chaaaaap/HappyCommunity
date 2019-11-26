package com.app.happycommunity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class myPostDeletion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postpicked);
        String creator = getIntent().getStringExtra("creator");
        String title=getIntent().getStringExtra("title");
        String reward =""+getIntent().getIntExtra("reward",0);

        TextView textViewCreator = (TextView) findViewById(R.id.pPCreator);
        TextView textViewTitle = (TextView) findViewById(R.id.titlePP);
        TextView textViewReward = (TextView) findViewById(R.id.rewardPP);
        textViewCreator.setText(creator);
        textViewReward.setText(reward);
        textViewTitle.setText(title);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Button acceptButton = (Button) findViewById(R.id.acceptBtn);
        Button declineButton = (Button)findViewById(R.id.declineBtn);
        acceptButton.setText("Delete Post");
        declineButton.setText("Back");

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Delete the post from database

            }
        });
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myPostDeletion.this, myPostOverview.class);

                startActivity(intent);
                finish();


            }
        });
    }
}
