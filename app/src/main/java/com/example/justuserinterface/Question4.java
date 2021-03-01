package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {

    RadioButton maleRadioButton;
    RadioButton femaleRadiobutton;
    Button showButton;
    Button hideCheckboxButton;
    Button backButton;
    CheckBox checkBox;
    Boolean flag;
    ConstraintLayout cLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        showButton=(Button) findViewById(R.id.show_Button);
        hideCheckboxButton=(Button) findViewById(R.id.hideCheckBox_Button);
        backButton=(Button) findViewById(R.id.back_button);
        maleRadioButton=(RadioButton) findViewById(R.id.male_radioButton);
        femaleRadiobutton=(RadioButton) findViewById(R.id.female_radioButton);
        checkBox=(CheckBox) findViewById(R.id.checkBox);
        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        flag=true;

        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(maleRadioButton.isChecked()){
                    Toast.makeText(Question4.this,"MALE🙋‍♂",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Question4.this,"FEMALE🙋‍♀",Toast.LENGTH_LONG).show();
                }

            }
        });



        hideCheckboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if(flag){
             checkBox.setVisibility(View.GONE);
             hideCheckboxButton.setText("Unhide CHECKBOX");
             flag=false;
                 }

                 else{
                     checkBox.setVisibility(View.VISIBLE);
                     hideCheckboxButton.setText("Hide CHECKBOX");
                     flag=true;
                 }

                if(checkBox.isChecked()){
                    checkBox.setText("I'M CHECKED");
                }
                else{
                    checkBox.setText("I'M NOT CHECKED");
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

    @Override
    protected void onResume() {
        super.onResume();



    }
}