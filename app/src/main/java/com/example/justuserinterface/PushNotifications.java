package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.allyants.notifyme.NotifyMe;

import java.util.Calendar;

public class PushNotifications extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button back_button;
    Button schedule_button;
    ConstraintLayout cLayout;
    EditText title_textField;
    EditText content_textField;

    Calendar now =Calendar.getInstance();
    com.wdullaer.materialdatetimepicker.time.TimePickerDialog tpd;
    com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifications);


        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        back_button=(Button)findViewById(R.id.back_button);
        schedule_button=(Button)findViewById(R.id.schedule_button);
        title_textField=(EditText)findViewById(R.id.title_textField);
        content_textField=(EditText)findViewById(R.id.content_textField);


        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();



        dpd= com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                (com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener)
                        PushNotifications.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH));

        tpd= com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance((com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener) PushNotifications.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),false
        );















        schedule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(PushNotifications.this,String.valueOf(Calendar.YEAR),Toast.LENGTH_LONG).show();



               dpd.show(getFragmentManager(),"Datepickerdialog");

            }
        });








        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

    }


    public void back(){
        Intent intent=new Intent(this,Mobille_Application_Assignment.class);
        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        now.set(Calendar.YEAR, year);
        now.set(Calendar.MONTH,month);
        now.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        tpd.show(getFragmentManager(),"Timepickerdialog");

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        now.set(Calendar.HOUR_OF_DAY, hourOfDay);
        now.set(Calendar.MINUTE,minute);



        NotifyMe notifyMe=new NotifyMe.Builder(getApplicationContext())
                .title(title_textField.getText().toString())
                .content(content_textField.getText().toString())
                .color(255,0,0,255)
                .led_color(255,255,255,255)
                .time(now)
                .addAction(new Intent(),"Snooze",false)
                .key("test")
                .addAction(new Intent(),"Dismiss",true,false)
                .addAction(new Intent(),"Done")
                .build();

    }
}