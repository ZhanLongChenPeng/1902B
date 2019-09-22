package com.example.xianshi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Switch
     */
    private Switch mSwitch1;
    /**
     * TextView
     */
    private TextView mTextView;
    /**
     * Button
     */
    private Button mButton;

    private int isxian=View.VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSwitch1 = (Switch) findViewById(R.id.switch1);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                if(isxian==View.VISIBLE) {
                    isxian=View.GONE;

                }else{
                    isxian=View.VISIBLE;
                }
                notifyDataSetChanged();
        }
    }

    private void notifyDataSetChanged() {
        mSwitch1.setVisibility(isxian);
    }
}
