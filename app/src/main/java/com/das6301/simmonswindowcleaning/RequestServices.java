package com.das6301.simmonswindowcleaning;
/**
 * Allows users to request the services they want to have done.
 *
 * @author David Simmons
 * @version 1.0
 * */
import androidx.appcompat.app.AppCompatActivity;

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
     *  onCheckboxClicked(View view)
     *
     *  Returns the values of CheckBoxs that are clicked.
     */
    public void onCheckboxClicked(View view){
        boolean isChecked = ((CheckBox) view).isChecked();
        rsOtherET = findViewById(R.id.requestService_other_ET);
        rsOtherTV = findViewById(R.id.requestService_other_TV);

        //  Switch cases for all the CheckBox
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
                }else{

                    rsOtherTV.setVisibility(View.GONE);
                    rsOtherET.setVisibility(View.GONE);

                }
                break;
        }
    }

    /**
     *  requestServicesNext(View view)
     *
     *  Opens up the RequestServicesFragment().
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

    }

    /**
     * servicesDescription(View view)
     *
     * Opens up the RecyclerView to show all the service description
     * */
    public void serviceDescription(View view){
        startActivity(new Intent(this, DisplayServices.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestservices);
    }
}