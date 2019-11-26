package com.app.happycommunity.asynctasks;

import android.os.AsyncTask;

import com.app.happycommunity.api.ApiUsers;
import com.app.happycommunity.models.GlobalData;
import com.app.happycommunity.models.LoginInfo;
import com.app.happycommunity.models.UserModel;

public class LoginAsyncTask extends AsyncTask<LoginInfo, LoginInfo, UserModel> {

    @Override
    protected UserModel doInBackground(LoginInfo... loginInfos) {
        if(loginInfos[0] == null) return null;
        return ApiUsers.Login(loginInfos[0]);

    }
}
