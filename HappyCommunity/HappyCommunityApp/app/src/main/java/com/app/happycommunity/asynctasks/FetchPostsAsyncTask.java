package com.app.happycommunity.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import com.app.happycommunity.api.ApiPosts;
import com.app.happycommunity.models.PostOverviewModel;

import java.util.ArrayList;

public class FetchPostsAsyncTask extends AsyncTask<Void, Void, ArrayList<PostOverviewModel>> {

    @Override
    protected ArrayList<PostOverviewModel> doInBackground(Void... voids) {
        return ApiPosts.getPosts();
    }
}
