package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExistingUser extends AppCompatActivity {
    Button loginBtn;

    public void existingUserLoginBtn(View view){


        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user);
        System.out.println("LOADING EXISTING USER PAGE.");

        loginBtn = findViewById(R.id.activity_existing_user_loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("LOGIN BUTTON SOUT");
                Toast.makeText(getApplicationContext(), "Login BUTTON TOAST", Toast.LENGTH_SHORT).show();
            }
        });
    }
}