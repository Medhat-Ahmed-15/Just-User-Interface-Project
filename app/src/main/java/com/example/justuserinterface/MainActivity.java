package com.example.justuserinterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button lightButton;
    Button signupButton;
    Button signinButton;
    Button rate_button;
    Button quit_button;


    String email="q";
    String password="q";

    EditText emailtextField;
    EditText passwordtextField;

    TextView hintTextView;

    ConstraintLayout cLayout;

    boolean switchButton=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightButton=(Button)findViewById(R.id.Light_Button);
        quit_button=(Button)findViewById(R.id.quit_button);
        rate_button=(Button)findViewById(R.id.rate_button);
        signinButton=(Button)findViewById(R.id.signin_button);
        signupButton=(Button)findViewById(R.id.signup_button);
        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        emailtextField=(EditText) findViewById(R.id.editTextTextPersonName);
        passwordtextField=(EditText) findViewById(R.id.editTextTextPassword);
        hintTextView=(TextView) findViewById(R.id.Hint_TextView);




        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openSignupActivity();

            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if((email.equals(emailtextField.getText().toString())&&password.equals(passwordtextField.getText().toString()))){
                 Toast.makeText(MainActivity.this,"😁",Toast.LENGTH_LONG).show();
                 openMobileAppActivity();


             }
             else{
                 Toast.makeText(MainActivity.this,"😢",Toast.LENGTH_LONG).show();
             }
            }
        });

        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchButton){
                    lightButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_on));
                    switchButton=false;
                    AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
                    animationDrawable.setEnterFadeDuration(2000);
                    animationDrawable.setExitFadeDuration(4000);
                    animationDrawable.stop();
                    hintTextView.setText("PLAY BACKGROUND ANIMATION");



                }
               else if(!switchButton){
                    lightButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_off));
                    switchButton=true;
                    AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
                    animationDrawable.setEnterFadeDuration(2000);
                    animationDrawable.setExitFadeDuration(4000);
                    animationDrawable.start();
                    hintTextView.setText("STOP BACKGROUND ANIMATION");



                }
            }
        });


        rate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openRateActivity();

            }
        });

        quit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                MainActivity.this.finish();
                                System.exit(0);

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                //here we build the texts that gonna be written in the interface of the alert box
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
               builder.setMessage("Are you sure you want to quit the program😥😥😥").setPositiveButton("👍", dialogClickListener)
                        .setNegativeButton("👎", dialogClickListener).show();



            }
        });


    }
    public void openSignupActivity(){
        Intent intent=new Intent(this,Signup_Page.class);
        startActivity(intent);
    }


    public void openMobileAppActivity(){
        Intent intent=new Intent(this,Mobille_Application_Assignment.class);
        startActivity(intent);
    }

    public void openRateActivity(){
        Intent intent=new Intent(this,Rate.class);
        startActivity(intent);
    }


   /* @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(MainActivity.this,"stop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(MainActivity.this,"pause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(MainActivity.this,"Destroy",Toast.LENGTH_LONG).show();
    }*/
}