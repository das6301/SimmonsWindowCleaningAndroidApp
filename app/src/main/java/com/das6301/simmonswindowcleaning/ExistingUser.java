package com.das6301.simmonswindowcleaning;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ExistingUser extends AppCompatActivity {

    FirebaseAuth fAuth;


    public void existingUserLoginBtn(View view){
        EditText uname = findViewById(R.id.activity_existing_user_login_editText);
        EditText pword = findViewById(R.id.activity_existing_user_password_editText);

        String username = uname.getText().toString().trim();
        String password = pword.getText().toString().trim();

        //Checking to see if username is empty
        if(TextUtils.isEmpty(username)){
            uname.setError("Username is Required!");
            return;
        }
        //Checking to see if password is empty
        if(TextUtils.isEmpty(password)){
            pword.setError("Password is Required!");
            return;
        }
        //Checking to see if password is less then 6 characters
        if(password.length() < 6) {
            pword.setError("Password Must be 6+ Characters");
            return;
        }

        // Authenticating the User
        fAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if(task.isSuccessful()){
                    Toast.makeText(ExistingUser.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent (getApplicationContext(), Homepage.class));
                }
                else {
                    Toast.makeText(ExistingUser.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user);
        System.out.println("LOADING EXISTING USER PAGE.");


    }

}