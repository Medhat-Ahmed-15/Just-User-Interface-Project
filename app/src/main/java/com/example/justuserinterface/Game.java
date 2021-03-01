package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Game extends AppCompatActivity {

    Button back_button;
    Button start_button;
    TextView word_text;
    TextView score_text;
    EditText input_textField;

    boolean endGame=false;

    int score=0;
    int i=-1;

    Handler handler=new Handler();



    String[] words={"bag","pencil","happy","great","bus"};



    ConstraintLayout cLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        back_button=(Button)findViewById(R.id.back_button);
        start_button=(Button)findViewById(R.id.start_button);
        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        word_text=(TextView) findViewById(R.id.word_text);
        score_text=(TextView) findViewById(R.id.score_text);
        input_textField=(EditText) findViewById(R.id.input_textField);





        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                change.run();



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


    //this runnable basicly encapculate  the code that we want to code after the delay
    private Runnable change=new Runnable(){
        @Override
        public  void run()
        {

            i++;

            if(i==4){
                i=0;
                //Toast.makeText(Game.this,"😁",Toast.LENGTH_LONG).show();
                //handler.removeCallbacks(change);//stop executing this runnable
            }

            word_text.setText(words[i]);

            handler.postDelayed(check,3000);

            if(endGame==false){
            handler.postDelayed(this,5000);}

        }
    };


    private Runnable check=new Runnable(){
        @SuppressLint("SetTextI18n")
        @Override
        public  void run()
        {

            if(input_textField.getText().toString().equals(words[i]))
            {
                input_textField.getText().clear();
                score=score+5;
                String scoreInString =String.valueOf(score);
                score_text.setText("Score: " + scoreInString);
            }
            else
            {
                Toast.makeText(Game.this,"LOSER😛",Toast.LENGTH_LONG).show();
                 endGame=true;
            }


        }
    };



}