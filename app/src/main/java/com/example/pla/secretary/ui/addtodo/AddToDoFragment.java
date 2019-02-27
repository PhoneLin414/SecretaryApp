package com.example.pla.secretary.ui.addtodo;


import android.animation.Animator;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.pla.secretary.R;
import com.example.pla.secretary.base.BaseFragment;
import com.example.pla.secretary.data.TodoItem;
import com.example.pla.secretary.utils.Utils;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddToDoFragment extends BaseFragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    public static AddToDoFragment Instance;

    private View view;

    TodoItem todoItem;

    String title, description;

    Boolean on = false;

    /***
     * Widgets
     */

    EditText edt_title_addtodo, edt_des_addtodo, edt_todo_time, edt_todo_date;
    ImageButton ibtn_savetodo;
    ImageView img_reminder;
    LinearLayout ll_reminder;
    TextView txt_clock;

    public AddToDoFragment() {
        // Required empty public constructor
    }

    public static AddToDoFragment getInstance() {

        if (Instance == null) {

            Instance = new AddToDoFragment();

        }

        return Instance;

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view = view;

        init();

        ibtn_savetodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTodoData()) {

                    getTodoData();

                    Intent saveTodo = new Intent();

                    todoItem = new TodoItem(title, description);

                    saveTodo.putExtra(Utils.ADDNEWTODO_INTENTKEY, todoItem);

                    getActivity().setResult(Utils.RESPONSE_CODE, saveTodo);

                    getActivity().finish();

                }


            }
        });

        img_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkOnOff()) {
                    img_reminder.animate().translationY(-50).setInterpolator(new BounceInterpolator()).setDuration(1000);
                    llReminderVisibleWithAnimation(true);
                    txt_clock.animate().translationX(-50).alpha(0.0f).setDuration(1000);

                } else {
                    img_reminder.animate().translationY(0).setInterpolator(new BounceInterpolator()).setDuration(1000);
                    llReminderVisibleWithAnimation(false);
                    txt_clock.animate().translationX(0).alpha(1.0f).setDuration(1000);
                }


            }
        });


        edt_todo_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard(edt_todo_date);

                Date date = new Date();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), AddToDoFragment.this, year, month, day);
                datePickerDialog.show();

            }
        });


        edt_todo_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard(edt_todo_time);


                Calendar calendar = Calendar.getInstance();

                int hour = calendar.get(Calendar.HOUR);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), AddToDoFragment.this, hour,minute,false );
                timePickerDialog.show();


            }
        });


    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_add_to_do;
    }

    private void init() {

        edt_title_addtodo = view.findViewById(R.id.edt_title_addtodo);
        edt_des_addtodo = view.findViewById(R.id.edt_des_addtodo);
        ibtn_savetodo = view.findViewById(R.id.fab_savetodo);
        img_reminder = view.findViewById(R.id.img_reminder);
        ll_reminder = view.findViewById(R.id.ll_reminder);
        txt_clock = view.findViewById(R.id.txt_clock);
        edt_todo_date = view.findViewById(R.id.edt_todo_date);
        edt_todo_time = view.findViewById(R.id.edt_todo_time);


    }

    private Boolean checkTodoData() {

        if (!TextUtils.isEmpty(edt_title_addtodo.getText()) && !TextUtils.isEmpty(edt_des_addtodo.getText())) {

            return true;

        } else {

            Toast.makeText(getActivity(), "Need to fill your todo information", Toast.LENGTH_SHORT).show();

            return false;
        }


    }

    private void getTodoData() {

        title = edt_title_addtodo.getText().toString();
        description = edt_des_addtodo.getText().toString();


    }

    private boolean checkOnOff() {

        if (!on) {
            on = true;
        } else {
            on = false;
        }

        return on;
    }

    private void llReminderVisibleWithAnimation(boolean onOff) {

        if (onOff) {

            ll_reminder.animate().alpha(1.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    ll_reminder.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

        } else {

            ll_reminder.animate().alpha(0.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ll_reminder.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

        }

    }

    private void hideKeyBoard(EditText edt) {

        if (getActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(edt.getWindowToken(), 0);
        }


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
