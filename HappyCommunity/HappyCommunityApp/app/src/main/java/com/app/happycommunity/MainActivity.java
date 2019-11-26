package com.app.happycommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.os.Bundle;

import com.app.happycommunity.asynctasks.LoginAsyncTask;
import com.app.happycommunity.models.GlobalData;
import com.app.happycommunity.models.LoginInfo;
import com.app.happycommunity.models.UserModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


    }

    @Override
    public void onResume() {
        super.onResume();
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText userName = (EditText) findViewById(R.id.userName);
        final Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel user = null;
                try {
                    user = new LoginAsyncTask().execute(new LoginInfo(userName.getText().toString(), password.getText().toString())).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (user != null) {
                    GlobalData.loggedInUser = user;
                    Intent intent = new Intent(MainActivity.this, postOverview.class);
                    startActivity(intent);
                }

            }
        });
    }

}