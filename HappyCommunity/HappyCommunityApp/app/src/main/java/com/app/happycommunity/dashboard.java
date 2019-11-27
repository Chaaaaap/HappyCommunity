package com.app.happycommunity;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.asynctasks.FetchAcceptedPostsAsyncTask;
import com.app.happycommunity.asynctasks.FetchPostsAsyncTask;
import com.app.happycommunity.models.GlobalData;
import com.app.happycommunity.models.PostOverviewModel;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        Button allPostsBtn = (Button) findViewById(R.id.allPosts);
        Button myPostsBtn = (Button) findViewById(R.id.myPosts);
        Button myAceptedPostBtn = (Button) findViewById(R.id.acceptedPosts);
        Button myPendingPostsBtn = (Button) findViewById(R.id.pendingPosts);
        TextView completedPosts = (TextView) findViewById(R.id.completedPosts);
        int [] count=new int [3];
        count=loadList();
        allPostsBtn.setText(allPostsBtn.getText().toString()+count[1]);
        myPostsBtn.setText(myPostsBtn.getText().toString()+count[0]);
        myAceptedPostBtn.setText(myAceptedPostBtn.getText().toString()+""+loadListPending(1));
        myPendingPostsBtn.setText(myPendingPostsBtn.getText().toString()+count[2]);
        completedPosts.setText(completedPosts.getText().toString()+loadListPending(2));
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
        myPendingPostsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, myPendingPosts.class);

                startActivity(intent);


            }
        });


    }
    private int loadListPending(int listType) {
        ArrayList<PostOverviewModel> temp =  new ArrayList<PostOverviewModel>();
        try {

            String posts = "info?username="+GlobalData.loggedInUser.getUsername()+"&status="+listType;
            temp = new FetchAcceptedPostsAsyncTask().execute(posts).get();

            if(temp.isEmpty()){
                return 0;
            }else {
            return temp.size();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int[] loadList() {
        ArrayList<PostOverviewModel> temp =  new ArrayList<PostOverviewModel>();
        ArrayList<PostOverviewModel> temp2 =  new ArrayList<PostOverviewModel>();
        try {

            int [] count = new int[3];
            temp = new FetchPostsAsyncTask().execute("0").get();
            temp2 = new FetchPostsAsyncTask().execute("1").get();
            if(temp.isEmpty()){

            }else {
                for(PostOverviewModel model: temp){
                    if(model.getUsername().equals(GlobalData.loggedInUser.getUsername())) {
                     count[0]++;
                    } else {
                        count[1]++;
                    }
                }
            }
            if(temp2.isEmpty()){
                count[2]=0;

            }else {
                for(PostOverviewModel model: temp2){
                    if(model.getUsername().equals(GlobalData.loggedInUser.getUsername())) {
                        count[2]++;

                    }

                }
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}