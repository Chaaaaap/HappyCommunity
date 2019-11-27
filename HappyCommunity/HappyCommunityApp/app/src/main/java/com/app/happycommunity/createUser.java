package com.app.happycommunity;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.asynctasks.LoginAsyncTask;

public class createUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        Button acceptBtn= (Button) findViewById(R.id.createUseracceptBtn);
        Button declineBtn= (Button) findViewById(R.id.createUserdeclineBtn);
        EditText nameText= (EditText) findViewById(R.id.createUsername);
        EditText numberText= (EditText) findViewById(R.id.createUserNumber);
        EditText addressText= (EditText) findViewById(R.id.createUserAddress);
        EditText passwordText= (EditText) findViewById(R.id.createUserPassword);
        EditText passwordText2= (EditText) findViewById(R.id.createUserPassword2);
        EditText usernameText= (EditText) findViewById(R.id.createUserUsername);


        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createUser.this, MainActivity.class);

                startActivity(intent);
                finish();



            }
        });
        declineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createUser.this, MainActivity.class);

                startActivity(intent);

                finish();

            }
        });


    }

}