package com.das6301.simmonswindowcleaning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

    TextView tv, welcomeTV;
    LinearLayout l1;
    LinearLayout l2;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String uId;
    EditText enewuName,enewName, enewaddress, enewnum, enewemail;
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

        tv.setVisibility(View.GONE);
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);

//        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//        uId = fAuth.getCurrentUser().getUid();
//        enewuName = findViewById(R.id.newusername);
//        enewName = findViewById(R.id.newname);
//        enewaddress = findViewById(R.id.newaddress);
//        enewnum = findViewById(R.id.newnum);
//        enewemail = findViewById(R.id.newemail);
//
//        DocumentReference dr = fStore.collection("users").document(uId);
//        dr.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                enewuName.setHint(value.getString("username"));
//                enewName.setHint(value.getString("name"));
//                enewaddress.setHint(value.getString("address"));
//                enewnum.setHint(value.getString("phoneNum"));
//                enewemail.setHint(value.getString("email"));
//            }
//        });

    }

    public void updateInfo(View view){
        Toast.makeText(getApplicationContext(), "Update Info", Toast.LENGTH_SHORT).show();
    }

    public void closeFrag(View view){
        Toast.makeText(getApplicationContext(), "Close Fragment", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Homepage.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        uId = fAuth.getCurrentUser().getUid();

//        welcomeTV = findViewById(R.id.homepage_welcome_textView);
//        enewuName = findViewById(R.id.newusername);
//        enewName = findViewById(R.id.newname);
//        enewaddress = findViewById(R.id.newaddress);
//        enewnum = findViewById(R.id.newnum);
//        enewemail = findViewById(R.id.newemail);

        // TODO: FIx bug with Sign Out Button and Error here!
        DocumentReference dr = fStore.collection("users").document(uId);
        dr.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                welcomeTV.setText(welcomeTV.getText().toString().trim() + " " + value.getString("username"));

            }
        });
    }
}