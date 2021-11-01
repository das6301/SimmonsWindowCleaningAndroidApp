package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    /**
     *  Function for changing to activity_existing_user.xml
     */
    public void euBtnOnClick(View v){
        Intent intent = new Intent(this, ExistingUser.class);
        startActivity(intent);
    }

    /**
     *  Function for chaging to activity_new_user.xml
     */
    public void nuBtnOnClick(View v){
        Intent intent = new Intent(this, NewUser.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

    }
}