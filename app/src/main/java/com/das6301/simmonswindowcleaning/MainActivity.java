package com.das6301.simmonswindowcleaning;

/**
 * MainActivity showing New and Existing User Button
 * @author David Simmons
 * @version 1.0
 * */

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    /**
     *  existingUser onClickListener
     *  Function for changing to activity_existing_user.xml
     */
    public void euBtnOnClick(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /**
     *  newUser onClickListener
     *  Function for chaging to activity_new_user.xml
     */
    public void nuBtnOnClick(View v){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }
}