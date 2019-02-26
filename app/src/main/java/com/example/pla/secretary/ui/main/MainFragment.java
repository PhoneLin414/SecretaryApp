package com.example.pla.secretary.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pla.secretary.R;
import com.example.pla.secretary.base.BaseFragment;
import com.example.pla.secretary.data.TodoItem;
import com.example.pla.secretary.ui.addtodo.AddToDoActivity;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {


    public static MainFragment Instance;

    /***
     * Widgets
     */
    FloatingActionButton fab_AddNewTodo;


    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment getInstance() {

        if (Instance == null) {

            Instance = new MainFragment();

        }

        return Instance;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (resultCode == 1){
           TodoItem todoItem = (TodoItem) data.getSerializableExtra("Key");
           Toast.makeText(getActivity(), todoItem.getTitle(), Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_main;
    }

}
