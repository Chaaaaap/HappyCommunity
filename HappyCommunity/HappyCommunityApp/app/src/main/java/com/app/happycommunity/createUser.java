package com.app.happycommunity;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.app.happycommunity.asynctasks.CreatePostAsyncTask;
import com.app.happycommunity.asynctasks.CreateUserAsyncTask;
import com.app.happycommunity.asynctasks.LoginAsyncTask;

public class createUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        Button acceptBtn= (Button) findViewById(R.id.createUseracceptBtn);
        Button declineBtn= (Button) findViewById(R.id.createUserdeclineBtn);
        final EditText nameText= (EditText) findViewById(R.id.createUsername);
        final EditText numberText= (EditText) findViewById(R.id.createUserNumber);
        final EditText addressText= (EditText) findViewById(R.id.createUserAddress);
        final EditText passwordText= (EditText) findViewById(R.id.createUserPassword);
        final EditText passwordText2= (EditText) findViewById(R.id.createUserPassword2);
        final EditText usernameText= (EditText) findViewById(R.id.createUserUsername);
        final EditText zipText= (EditText) findViewById(R.id.createUserZip);
        final EditText cityText= (EditText) findViewById(R.id.createUserCity);


        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createUser.this, MainActivity.class);


                if(passwordText.getText().toString().equals(passwordText2.getText().toString())){
                    String createUser="info?username="+usernameText.getText().toString()+"&password="+passwordText.getText().toString()+"&name="+nameText.getText().toString()+"&address="+addressText.getText().toString()
                            +"&phonenumber="+numberText.getText().toString()+"&zipcode="+zipText.getText().toString()+"&city="+cityText.getText().toString();
                    try{
                        new CreateUserAsyncTask().execute(createUser).get();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    startActivity(intent);
                    finish();
                }




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