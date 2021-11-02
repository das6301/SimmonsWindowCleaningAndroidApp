package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class NewUser extends AppCompatActivity {

    public void newUserConfirmBtn(View view){

        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        System.out.println("LOADING NEW USER PAGE.");

    }

    
}