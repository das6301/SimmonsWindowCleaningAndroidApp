package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

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
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        Toast.makeText(getApplicationContext(), "Signed Out.",Toast.LENGTH_SHORT).show();
        finish();
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