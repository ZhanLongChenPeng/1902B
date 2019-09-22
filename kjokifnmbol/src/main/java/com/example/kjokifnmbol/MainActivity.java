package com.example.kjokifnmbol;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.kjokifnmbol.adapter.MyVp;
import com.example.kjokifnmbol.fragment.CallerFragment;
import com.example.kjokifnmbol.fragment.ShouFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.te)
    TextView mTe;
    @BindView(R.id.tool)
    Toolbar mTool;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    private ArrayList <Fragment> list;
    private MyVp myVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        list = new ArrayList <>();
        list.add(new ShouFragment());
        list.add(new CallerFragment());

        myVp = new MyVp(getSupportFragmentManager(), list);
        mVp.setAdapter(myVp);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("首页");
        mTab.getTabAt(1).setText("下载");

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTe.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
