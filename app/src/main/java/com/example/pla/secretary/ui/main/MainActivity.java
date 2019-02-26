package com.example.pla.secretary.ui.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.pla.secretary.R;
import com.example.pla.secretary.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setContentViewRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Fragment createFragment() {
        return MainFragment.getInstance();
    }


}
