package com.example.pla.secretary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.pla.secretary.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewRes()); // 1
        setInitialFragment(savedInstanceState); // 2
    }

    protected abstract int setContentViewRes();

    private void setInitialFragment(Bundle savedInstanceState) {

        if (savedInstanceState == null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,createFragment())
                    .commit();

        }

    }

    protected abstract Fragment createFragment();
}
