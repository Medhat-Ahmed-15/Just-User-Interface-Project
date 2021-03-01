package com.example.justuserinterface;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Counter extends AppCompatActivity {

    ConstraintLayout cLayout;

    Button counterButton;
    Button backButton;

    RadioButton counterUpRadiobutton;
    RadioButton counterDownRadiobutton;

    EditText outputEditText;

    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        counterButton=(Button) findViewById(R.id.Count_Button);
        backButton=(Button) findViewById(R.id.back_button);
        counterUpRadiobutton=(RadioButton) findViewById(R.id.CounterUp_radioButton);
        counterDownRadiobutton=(RadioButton) findViewById(R.id.CounterDown_radioButton);
        outputEditText=(EditText) findViewById(R.id.Output_EditText);
        mainActivity=new MainActivity();


        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(counterUpRadiobutton.isChecked()){
                   int x=Integer.parseInt(outputEditText.getText().toString());
                    String output = String.valueOf(x+1);
                    outputEditText.setText(output);
                }

                else{
                    int x=Integer.parseInt(outputEditText.getText().toString());
                    outputEditText.setText(x-1 + "");

                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
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
}