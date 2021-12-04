package com.das6301.simmonswindowcleaning;

/**
 * inflating the RequestServicesFragment
 *
 * @author David Simmons
 * @version 1.0
 * */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class RequestServicesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.request_services_fragment, container);

        return rootView;
    }

}
