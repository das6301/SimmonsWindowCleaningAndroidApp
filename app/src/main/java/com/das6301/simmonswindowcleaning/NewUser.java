package com.das6301.simmonswindowcleaning;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class NewUser extends AppCompatActivity {

    FirebaseAuth fAuth;
    //FirebasaeFirestore fStore;

    EditText username, password, confirmPassword, name, address, phoneNum, email;

    public void newUserConfirmBtn(View view){
        username = findViewById(R.id.activity_new_user_username_editText);
        password = findViewById(R.id.activity_new_user_password_editText);
        confirmPassword = findViewById(R.id.activity_new_user_confirm_password_editText);
        name = findViewById(R.id.activity_new_user_Name);
        address = findViewById(R.id.activity_new_user_Address);
        phoneNum = findViewById (R.id.activity_new_user_PhoneNumber);
        email = findViewById(R.id.activity_new_user_Email);

        String s_username = username.getText().toString().trim();
        String s_password = password.getText().toString().trim();
        String s_confirmPassword = confirmPassword.getText().toString().trim();
        String s_name = name.getText().toString().trim();
        String s_address = address.getText().toString().trim();
        String s_phoneNum  = phoneNum.getText().toString().trim();
        String s_email = email.getText().toString().trim();
        if(TextUtils.isEmpty(s_username)){
            username.setError("Username is required");
            return;
        }
        if(TextUtils.isEmpty(s_password)){
            password.setError("Password is required");
            return;
        }
        if(s_password.length() < 6){
            password.setError("Passwords Must be at least 6 Characters!");
            return;
        }
        if(!s_password.equals(s_confirmPassword)){
            confirmPassword.setError("Passwords Must Match!");
            return;
        }
        if(TextUtils.isEmpty(s_name)){
            name.setError("Name is required");
            return;
        }
        if(TextUtils.isEmpty(s_address)){
            address.setError("Address is required!");
            return;
        }
        if(TextUtils.isEmpty(s_phoneNum)){
            phoneNum.setError("Phone Number is required!");
            return;
        }
        if(TextUtils.isEmpty(s_email)){
            email.setError("Email is required!");
            return;
        }

//        fAuth.createUserWithEmailAndPassword(s_username, s_password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
//            @Override
//            public void onComplete (@NonNull Task<AuthResult> task){
//                if(task.isSuccessful()){
//                    ;
//                }
//            }
//        });

        startActivity(new Intent(this, Homepage.class));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

//        if(fAuth.getCurrentUser() != null){
//            startActivity(new Intent(this, Homepage.class));
//            finish();
//        }
    }

    
}