package com.example.pla.secretary.ui.addtodo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pla.secretary.R;
import com.example.pla.secretary.base.BaseActivity;

public class AddToDoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setContentViewRes() {
        return R.layout.activity_add_to_do;
    }

    @Override
    protected Fragment createFragment() {
        return AddToDoFragment.getInstance();
    }
}
