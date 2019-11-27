package com.app.happycommunity;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        Button allPostsBtn= (Button) findViewById(R.id.allPosts);
        Button myPostsBtn= (Button) findViewById(R.id.myPosts);
        Button myAceptedPostBtn= (Button) findViewById(R.id.acceptedPosts);
        Button myPendingPostsBtn=(Button)findViewById(R.id.pendingPosts);

        allPostsBtn.setText(allPostsBtn.getText().toString());
        allPostsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, postOverview.class);

                startActivity(intent);



            }
        });
        myPostsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, myPostOverview.class);

                startActivity(intent);



            }
        });
        myAceptedPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, myAcceptedPosts.class);

                startActivity(intent);



            }
        });

    }

}