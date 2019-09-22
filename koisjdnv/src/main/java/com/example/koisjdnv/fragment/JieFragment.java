package com.example.koisjdnv.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.koisjdnv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JieFragment extends Fragment {


    public JieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_jie, container, false);
        return inflate;
    }

}
