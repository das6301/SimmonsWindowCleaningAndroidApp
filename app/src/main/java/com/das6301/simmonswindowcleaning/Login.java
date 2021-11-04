package com.das6301.simmonswindowcleaning;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    FirebaseAuth mAuth;


    public void loginLoginBtn(View view){
        mAuth = FirebaseAuth.getInstance();


        EditText m_email = findViewById(R.id.activity_login_email_editText);
        EditText pword = findViewById(R.id.activity_login_password_editText);
        ProgressBar progressBar = findViewById(R.id.activity_login_progressBar);
        String email = m_email.getText().toString().trim();
        String password = pword.getText().toString().trim();

        //Checking to see if email is empty
        if(TextUtils.isEmpty(email)){
            m_email.setError("Email is Required!");
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

        // Displaying the ProgressBar
        progressBar.setVisibility(View.VISIBLE);


        // Authenticating the User
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent (getApplicationContext(), Homepage.class));
                }
                else {
                    Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();                }
                    progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void forgotPassword(View view){
        TextView forgotpassword = findViewById(R.id.forgotPassword);
        mAuth = FirebaseAuth.getInstance();
        EditText reset = new EditText(view.getContext());
        AlertDialog.Builder passResetDialog = new AlertDialog.Builder(view.getContext());
        passResetDialog.setTitle("Reset password?");
        passResetDialog.setMessage("Enter Your Email to Receive Reset Link.");
        passResetDialog.setView(reset);

        passResetDialog.setPositiveButton("Yes.", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get email and send link
                String mail = reset.getText().toString().trim();
                mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>(){
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this, "Reset Link sent to " + mail, Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener(){
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "Error, failed to send link to" + mail, Toast.LENGTH_SHORT).show();
                        Toast.makeText(Login.this, "The problem was " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        passResetDialog.setNegativeButton("No.", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // close dialog
            }
        });
        passResetDialog.create().show();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

}