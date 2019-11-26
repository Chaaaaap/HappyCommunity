package com.app.happycommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static String Username;
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
                Intent intent = new Intent(MainActivity.this, postOverview.class);
                Username=userName.getText().toString();
                startActivity(intent);

            }
        });
    }

}