package com.app.happycommunity.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import com.app.happycommunity.api.ApiPosts;
import com.app.happycommunity.models.PostOverviewModel;

import java.util.ArrayList;

public class FetchAcceptedPostsAsyncTask extends AsyncTask<String, String, ArrayList<PostOverviewModel>> {

    @Override
    protected ArrayList<PostOverviewModel> doInBackground(String... voids) {
        return ApiPosts.getAcceptedPosts(voids[0]);
    }
}
