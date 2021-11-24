package com.das6301.simmonswindowcleaning;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AccountInformation extends Fragment {

    EditText usernameET, nameET, addressET, numberET, emailET;
    View rootView;
    Button updateFragBtn;
    public AccountInformation() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView =inflater.inflate(R.layout.fragment_account_information, container, false);

        // Inflate the layout for this fragment
        String username, address, email, name, phoneNum;
        username = requireArguments().getString("username");
        address = requireArguments().getString("address");
        email = requireArguments().getString("email");
        name = requireArguments().getString("name");
        phoneNum = requireArguments().getString("phoneNum");

        usernameET = rootView.findViewById(R.id.newusername);
        addressET = rootView.findViewById(R.id.newaddress);
        emailET = rootView.findViewById(R.id.newemail);
        nameET = rootView.findViewById(R.id.newname);
        numberET = rootView.findViewById(R.id.newnum);
        updateFragBtn = rootView.findViewById(R.id.update_fragment_btn);


        usernameET.setText(username);
        addressET.setText(address);
        emailET.setText(email);
        nameET.setText(name);
        numberET.setText(phoneNum);

        updateFragBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {


            }
        });


//        System.out.println("User Information from Account Information Fragment "
//        + username+ "\n" + address + "\n" + email + "\n" + name +"\n" +phoneNum);
        return rootView;
    }
}