package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rate extends AppCompatActivity {

    ConstraintLayout cLayout;

    Button back_button;
    RatingBar ratingBar;

    int flag=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        back_button=(Button) findViewById(R.id.back_button);
        ratingBar=(RatingBar) findViewById(R.id.ratingBar);

        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                float rate= (int) ratingBar.getRating();

                if(rate==1){
                    String rating = "😭";
                    Toast.makeText(Rate.this,rating,Toast.LENGTH_SHORT).show();

                }

                if(rate==2){
                    String rating = "😥";
                    Toast.makeText(Rate.this,rating,Toast.LENGTH_SHORT).show();

                }

                if(rate==3){
                    String rating = "😕";
                    Toast.makeText(Rate.this,rating,Toast.LENGTH_SHORT).show();

                }

                if(rate==4){
                    String rating = "😄";
                    Toast.makeText(Rate.this,rating,Toast.LENGTH_SHORT).show();

                }

                if(rate==5){
                    String rating = "😁";
                    Toast.makeText(Rate.this,rating,Toast.LENGTH_SHORT).show();

                }


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
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}