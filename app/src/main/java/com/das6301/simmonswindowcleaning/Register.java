package com.das6301.simmonswindowcleaning;
/**
 * Allows users to make an account and stores the information in firebase
 *
 * @author David Simmons
 * @version 1.0
 * */

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

//TODO: GET ROOM DB TO WORK REPLACE THE FIREBASE DB STORAGE WITH ROOM.

public class Register extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    EditText username, password, confirmPassword, name, address, phoneNum, email;
    String userID;
    ProgressBar progressBar;

    /**
     * registerConfirmBtn(View view)
     *
     * Stores all the user information and does the error checking
     */
    public void registerConfirmBtn(View view){
        // Current instance of the database
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        // Finding all the Id's
        username = findViewById(R.id.activity_register_username_editText);
        password = findViewById(R.id.activity_register_password_editText);
        confirmPassword = findViewById(R.id.activity_register_confirm_password_editText);
        name = findViewById(R.id.activity_register_Name);
        address = findViewById(R.id.activity_register_Address);
        phoneNum = findViewById (R.id.activity_register_PhoneNumber);
        email = findViewById(R.id.activity_register_Email);
        progressBar = findViewById(R.id.activity_register_progressBar);

        // Getting the string values of the Id's
        String s_username = username.getText().toString().trim();
        String s_password = password.getText().toString().trim();
        String s_confirmPassword = confirmPassword.getText().toString().trim();
        String s_name = name.getText().toString().trim();
        String s_address = address.getText().toString().trim();
        String s_phoneNum  = phoneNum.getText().toString().trim();
        String s_email = email.getText().toString().trim();

        // Doing Error checking.
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

        // Displaying progressBar
        progressBar.setVisibility(View.VISIBLE);

        // Registering the user.
        mAuth.createUserWithEmailAndPassword(s_email, s_password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();

                    //Create new doc in cloud Firestore for the new user profile and add their name.
                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("users").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("name", s_name);
                    user.put("email", s_email);
                    user.put("phoneNum", s_phoneNum);
                    user.put("username", s_username);
                    user.put("address", s_address);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                        }
                    });



                    startActivity(new Intent(Register.this, Homepage.class));
                }else{
                    Toast.makeText(Register.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    
}