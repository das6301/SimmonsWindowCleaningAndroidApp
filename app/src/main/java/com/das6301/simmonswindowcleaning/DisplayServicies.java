package com.das6301.simmonswindowcleaning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DisplayServicies extends AppCompatActivity {

    String services[], servicesDesc[];
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_servicies);

        // Link to Services/Service Description
        services = getResources().getStringArray(R.array.services_requested);
        servicesDesc = getResources().getStringArray(R.array.services_requested_description);
        recyclerView = findViewById(R.id.frag_req_services_RV);

        myAdapter myAdapter = new myAdapter(this, services, servicesDesc);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}