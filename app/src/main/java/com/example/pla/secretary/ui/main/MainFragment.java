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
import com.example.pla.secretary.utils.Utils;

import java.io.Serializable;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {


    public static MainFragment Instance;

    private View view;

    TodoItem todoItem;

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

        this.view = view;

        init();


        fab_AddNewTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent addNewTodo = new Intent(getActivity(),AddToDoActivity.class); // 1

                todoItem = new TodoItem("","");

                addNewTodo.putExtra(Utils.ADDNEWTODO_INTENTKEY,todoItem);

                startActivityForResult(addNewTodo,Utils.REQUEST_CODE);

            }
        });


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_CANCELED && resultCode == Utils.RESPONSE_CODE && requestCode == Utils.REQUEST_CODE){

            todoItem = (TodoItem) data.getSerializableExtra(Utils.ADDNEWTODO_INTENTKEY);

            Toast.makeText(getActivity(), todoItem.getTitle() +" "+ todoItem.getDescription(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_main;
    }


    private void init(){

        fab_AddNewTodo = view.findViewById(R.id.fab_addnewtodo);

    }

}
