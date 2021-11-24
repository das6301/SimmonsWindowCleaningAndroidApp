package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class RequestServices extends AppCompatActivity {

    String windows, gutters, chandelier, leaves, siding, other;
    EditText rsOtherET;
    TextView rsOtherTV;

    /**
     *  onCheckboxClicked onClickListener
     */
    public void onCheckboxClicked(View view){
        // TODO: MAKE THE CHECKBOX CLICKED VALUES
        boolean isChecked = ((CheckBox) view).isChecked();
        rsOtherET = findViewById(R.id.requestService_other_ET);
        rsOtherTV = findViewById(R.id.requestService_other_TV);


        switch (view.getId()){
            case R.id.checkbox_windows:
                if (isChecked ){
                    windows = "Windows";
                    System.out.println("Windows Checked.");
                } else{
                    windows = "";
                }
                break;
            case R.id.checkbox_gutters:
                if (isChecked){
                    gutters = "Gutters";
                    System.out.println("Gutters Checked.");
                }else{
                    gutters = "";
                }
                break;
            case R.id.checkbox_chandelier:
                if (isChecked){
                    chandelier = "Chandelier";
                    System.out.println("Chandelier Checked.");
                }else{
                    chandelier = "";
                }
                break;
            case R.id.checkbox_leaves:
                if (isChecked){
                    leaves = "Leaves";
                    System.out.println("Leaves Checked.");
                }else{
                    leaves = "";
                }
                break;
            case R.id.checkbox_siding:
                if (isChecked){
                    siding = "Siding";
                    System.out.println("Siding Checked.");
                }else{
                    siding = "";
                }
                break;
            case R.id.checkbox_other:
                if (isChecked){
                    rsOtherTV.setVisibility(View.VISIBLE);
                    rsOtherET.setVisibility(View.VISIBLE);
                    other = rsOtherET.getText().toString().trim();
                    System.out.println("Other Checked.");
                }else{

                    rsOtherTV.setVisibility(View.GONE);
                    rsOtherET.setVisibility(View.GONE);
                    siding = "";
                }
                break;
        }
    }

    /**
     *  requestServicesNext onClickListener
     */
    public void requestServiceNext(View view){
        EditText editText = findViewById(R.id.jobaddress_requestservices_edittext);
        String jobAddress = editText.getText().toString().trim();

        // Doing Error checking.
        if(TextUtils.isEmpty(jobAddress)){
            editText.setError("Job Address Is Required");
            return;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_view_RS, new RequestServicesFragment()).commit();


        System.out.println("Services Selected: " + windows + " " + gutters + " " + chandelier + " " + leaves  + " " + siding);

    }

    public void serviceDescription(View view){
        startActivity(new Intent(this, DisplayServicies.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestservices);
    }
}