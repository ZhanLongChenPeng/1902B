package com.example.lkpdmb.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lkpdmb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VpFragment extends Fragment {


    private View view;
    private ImageView mIv;
    private Fragment context;
    private int isxian = View.VISIBLE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_vp, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        Bundle arguments = getArguments();
        String imgUrl = (String) arguments.get("imgUrl");
        Log.i("t", "哦IP来得及波: "+imgUrl);
        Glide.with(getActivity()).load(imgUrl).into(mIv);
    }

    private void initView(View inflate) {
        mIv = (ImageView) inflate.findViewById(R.id.iv);
    }
}
