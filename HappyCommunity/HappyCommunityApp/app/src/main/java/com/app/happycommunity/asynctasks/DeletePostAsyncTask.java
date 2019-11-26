package com.app.happycommunity.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import com.app.happycommunity.api.ApiPosts;
import com.app.happycommunity.models.PostOverviewModel;

import java.util.ArrayList;

public class DeletePostAsyncTask extends AsyncTask<Integer, Integer,PostOverviewModel>{

    @Override
    protected PostOverviewModel doInBackground(Integer... voids) {
        return ApiPosts.deletePost(voids[0]);
    }
}
