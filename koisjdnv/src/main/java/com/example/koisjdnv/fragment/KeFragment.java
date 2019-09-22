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
public class KeFragment extends Fragment {


    public KeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_ke2, container, false);
        return inflate;
    }

}
