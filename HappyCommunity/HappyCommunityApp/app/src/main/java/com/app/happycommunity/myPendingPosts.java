package com.app.happycommunity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.app.happycommunity.asynctasks.FetchPostsAsyncTask;
import com.app.happycommunity.models.GlobalData;
import com.app.happycommunity.models.PostOverviewModel;

import java.util.ArrayList;

public class myPendingPosts extends AppCompatActivity{
    ListView postList;
    postOverviewAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_view);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        postList=(ListView) findViewById(R.id.postList);
        adapter = new postOverviewAdapter(getApplicationContext());
        postList.setAdapter(adapter);
        adapter.clear();
        TextView header = (TextView) findViewById(R.id.postHeader);
        header.setText("My Pending Posts");
        final Button createPostButton = (Button) findViewById(R.id.createpostPO);
        final Button dashboardBtn = (Button) findViewById(R.id.dashboard);
        final Button myPostsButton = (Button) findViewById(R.id.mypostsPO);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        myPostsButton.setText("All Posts");

        loadList();



        postList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                PostOverviewModel post = (PostOverviewModel) adapter.getItemAtPosition(position);
                Intent intent = new Intent(myPendingPosts.this, showPendingPost.class);
                intent.putExtra("ID",post.getId()+"");

                startActivity(intent);
                finish();
            }
        });


        myPostsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myPendingPosts.this, postOverview.class);

                startActivity(intent);
                finish();


            }
        });

        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myPendingPosts.this, dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myPendingPosts.this, createPost.class);

                startActivity(intent);
                finish();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                loadList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
    private void loadList() {
        ArrayList<PostOverviewModel> temp =  new ArrayList<PostOverviewModel>();
        try {
            String posts = "1";

            temp = new FetchPostsAsyncTask().execute(posts).get();
            if(temp.isEmpty()){

            }else {
                for(PostOverviewModel model: temp){
                    if(model.getUsername().equals(GlobalData.loggedInUser.getUsername())) {
                        adapter.add(model);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
