package com.app.happycommunity.asynctasks;

import android.os.AsyncTask;

import com.app.happycommunity.api.ApiPosts;
import com.app.happycommunity.models.PostOverviewModel;

public class CreateUserAsyncTask extends AsyncTask<String, String, PostOverviewModel> {

    @Override
    protected PostOverviewModel doInBackground(String... voids) {
        return ApiPosts.createUser(voids[0]);
    }
}