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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Homepage extends AppCompatActivity {

    TextView tv, welcomeTV;

    LinearLayout l1;
    LinearLayout l2;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    Boolean change = false;
    String uId;
    EditText enewuName,enewName, enewaddress, enewnum, enewemail;
    String s1, s2, s3, s4, s5;
    DocumentReference dr;
    DatabaseReference reference;


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
        startActivity(new Intent(getApplicationContext(), aboutUs.class));
    }

    /**
     *  fab onClickListener
     */
    public void fab(View view){


        Bundle bundle = new Bundle();
        bundle.putString("username", s1 );
        bundle.putString("address", s2);
        bundle.putString("email", s3);
        bundle.putString("name", s4);
        bundle.putString("phoneNum", s5);
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_account_info_container, AccountInformation.class, bundle)
                .commit();

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
//    public void updateInfo(View view){
//        Toast.makeText(getApplicationContext(), "Update Info", Toast.LENGTH_SHORT).show();
//        //TODO: work on displaying/updating user info
//    }

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

    public void update(String username, String address, String email, String name, String number, Boolean tf ){
        s1 = username;
        s2 = address;
        s3 = email;
        s4=name;
        s5=number;
        change = tf;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        uId = fAuth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference("users");
        welcomeTV = findViewById(R.id.homepage_welcome_textView);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        dr = fStore.collection("users").document(uId);
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
                }
            }
        });



    }
}