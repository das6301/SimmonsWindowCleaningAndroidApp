package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    /**
     *  requestServices onClickListener
     *  links to the requestServices.xml
     */
    public void requestService(View view){

        Intent intent = new Intent(this, RequestServices.class);
        startActivity(intent);
    }

    /**
     *  fileComplaint onClickListener
     */
    public void fileComplaint(View view){
        // TODO: CREATE FILECOMPLAINT PAGE HERE.
    }

    /**
     *  signOut onClickListener
     */
    public void signOut(View v){
        // TODO: CREATE ACTION FOR THE SIGNOUT BUTTON
    }

    /**
     *  aboutUs onClickListener
     *  links to the aboutUs.xml
     **/
    public void aboutUs(View view){
        //  TODO: CREATE ABOUT US CLASS AND LINK TO PAGE.
    }

    /**
     *  fab onClickListener
     */
    public void fab(View view){
        // TODO: CREATE THE FLOATING ACTION BUTTON ACTION.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }



}