package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class NewUser extends AppCompatActivity {

    //Button testbtn;

    public void addButtonClick(View view){

            Toast.makeText(getApplicationContext(), "DOES THE BUTTON WORK?", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        System.out.println("LOADING NEW USER PAGE.");

//        testbtn = findViewById(R.id.addButton);

//        testbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Does this button work?", Toast.LENGTH_LONG).show();
//            }
//        });
    }

    
}