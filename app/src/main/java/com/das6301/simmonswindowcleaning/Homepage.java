package com.das6301.simmonswindowcleaning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Homepage extends AppCompatActivity {

    TextView tv, welcomeTV, accInfotv;
    LinearLayout l1;
    LinearLayout l2;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String uId;
    EditText enewuName,enewName, enewaddress, enewnum, enewemail;
    String s1, s2, s3, s4, s5;

    /**
     *  requestServices onClickListener
     *  links to the requestServices.xml
     */
    public void requestService(View view){
        startActivity(new Intent(this, RequestServices.class));
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


        getSupportFragmentManager().beginTransaction().add(R.id.fragment_account_info_container, new AccountInformation()).commit();

        tv = findViewById(R.id.homepage_welcome_textView);
        l1 = findViewById(R.id.hompage_lin1);
        l2 = findViewById(R.id.homepage_lin2);
        enewuName = findViewById(R.id.newusername);
        enewName = findViewById(R.id.newname);

        tv.setVisibility(View.GONE);
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
    }

    /**
     *  updateInfor()
     *  onClickListener for update_fragment_btn
     *
     * @param view
     */
    public void updateInfo(View view){
        Toast.makeText(getApplicationContext(), "Update Info", Toast.LENGTH_SHORT).show();
        //TODO: work on displaying/updating user info
    }

    /**
     *  closeFrag()
     *  onClickListener for close_fragment_btn
     *
     *  @param view
     */
    public void closeFrag(View view){
        Toast.makeText(getApplicationContext(), "Returning to Homepage.", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().remove(new AccountInformation()).commit();
        startActivity(new Intent(this, Homepage.class));
    }

    /**
     * Overrides onBackPressed() to let the user know they
     * will be signed out.
     */
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder addReplyDialog = new AlertDialog.Builder(this);
        addReplyDialog.setMessage("Really logout?");

        addReplyDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Homepage.super.onBackPressed();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                Toast.makeText(getApplicationContext(), "Signed Out.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        addReplyDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        addReplyDialog.create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        uId = fAuth.getCurrentUser().getUid();

        welcomeTV = findViewById(R.id.homepage_welcome_textView);
        //accInfotv = findViewById(R.id.t1username);

        DocumentReference dr = fStore.collection("users").document(uId);
        dr.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    System.out.println("Listen Failed: " + error);
                    return;
                }else {
                    welcomeTV.setText(welcomeTV.getText().toString().trim() + "\n" + documentSnapshot.getString("username"));
                    s1 = documentSnapshot.getString("username");
                    s2 = documentSnapshot.getString("address");
                    s3 = documentSnapshot.getString("email");
                    s4 = documentSnapshot.getString("name");
                    s5 = documentSnapshot.getString("phoneNum");
                    System.out.println("Username: " + s1 +
                            "\nAddress: " + s2 + "\nEmail: " + s3 +"\nName: " + s4 +"\nPhone Number: " + s5);
                }
            }
        });
    }
}