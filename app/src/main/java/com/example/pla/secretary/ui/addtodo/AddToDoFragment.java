package com.example.pla.secretary.ui.addtodo;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pla.secretary.R;
import com.example.pla.secretary.base.BaseFragment;
import com.example.pla.secretary.data.TodoItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddToDoFragment extends BaseFragment {


    public static AddToDoFragment Instance;

    public AddToDoFragment() {
        // Required empty public constructor
    }

    public static AddToDoFragment getInstance(){

        if (Instance == null){

            Instance = new AddToDoFragment();

        }

        return Instance;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_add_to_do;
    }

}
