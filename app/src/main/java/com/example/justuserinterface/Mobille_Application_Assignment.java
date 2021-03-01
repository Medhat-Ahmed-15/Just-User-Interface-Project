package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mobille_Application_Assignment extends AppCompatActivity {

    ConstraintLayout cLayout;

    Button calculatorButton;
    Button counterButton;
    Button backButton;
    Button fragmentsButton;
    Button question4Button;
    Button question6Button;
    Button gesturesAndFragmentsButton;
    Button colorPicker_button;
    Button foodMenuListButton;
    Button swipViews_button;
    Button uploadPicturesAndVideosbutton;
    Button spinTheBottle_button;
    Button dice_button;
    Button notification_button;
    Button game_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobille__application__assignment);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        calculatorButton=(Button)findViewById(R.id.Calculator_button);
        foodMenuListButton=(Button)findViewById(R.id.foodMenuListButton);
        gesturesAndFragmentsButton=(Button)findViewById(R.id.gesturesAndFragmentsButton);
        counterButton=(Button)findViewById(R.id.Counter_button);
        backButton=(Button)findViewById(R.id.back_button);
        question4Button=(Button)findViewById(R.id.question4_button);
        question6Button=(Button)findViewById(R.id.question6_button);
        fragmentsButton=(Button)findViewById(R.id.Fragments_button);
        colorPicker_button=(Button)findViewById(R.id.colorPicker_button);
        swipViews_button=(Button)findViewById(R.id.swipViews_button);
        spinTheBottle_button=(Button)findViewById(R.id.spinTheBottle_button);
        uploadPicturesAndVideosbutton=(Button)findViewById(R.id.uploadPicturesAndVideosbutton);
        dice_button=(Button)findViewById(R.id.dice_button);
        notification_button=(Button)findViewById(R.id.notification_button);
        game_button=(Button)findViewById(R.id.game_button);





        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyCalculatorActivity();
            }
        });

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCounterActivity();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                back();

            }
        });

        fragmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFragmentsTestActivity();

            }
        });

        question4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openQuestion4Activity();

            }
        });

        question6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openQuestion6Activity();

            }
        });

        gesturesAndFragmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGesturesAndfragmentsActivity();

            }
        });

        colorPicker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openColorPickerActivity();

            }
        });

        foodMenuListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFoodMenuActivity();

            }
        });

        swipViews_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openSwipViewsActivity();

            }
        });

        uploadPicturesAndVideosbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openUploadPicturesAndVideosActivity();

            }
        });

        spinTheBottle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spinTheBottleActivity();

            }
        });


        dice_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                diceActivity();

            }
        });


        notification_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notificationActivity();

            }
        });


        game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GameActivity();

            }
        });

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void openMyCalculatorActivity(){
        Intent intent=new Intent(this,My_Calculator.class);
        startActivity(intent);
    }

    public void back(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void openCounterActivity(){
        Intent intent=new Intent(this,Counter.class);
        startActivity(intent);
    }

    public void openFragmentsTestActivity(){
        Intent intent=new Intent(this,Fragments_Test.class);
        startActivity(intent);
    }

    public void openQuestion4Activity(){
        Intent intent=new Intent(this,Question4.class);
        startActivity(intent);
    }

    public void openQuestion6Activity(){
        Intent intent=new Intent(this,Question6.class);
        startActivity(intent);
    }

    public void openGesturesAndfragmentsActivity(){
        Intent intent=new Intent(this,GesturesAndFragments.class);
        startActivity(intent);
    }

    public void openColorPickerActivity(){
        Intent intent=new Intent(this,ColorPicker.class);
        startActivity(intent);
    }

    public void openFoodMenuActivity(){
        Intent intent=new Intent(this,FoodMenu.class);
        startActivity(intent);
    }

    public void openSwipViewsActivity(){
        Intent intent=new Intent(this,SwipView.class);
        startActivity(intent);
    }

    public void openUploadPicturesAndVideosActivity(){
        Intent intent=new Intent(this,UploadPicturesAndVideos.class);
        startActivity(intent);
    }

    public void spinTheBottleActivity(){
        Intent intent=new Intent(this,SpinTheBottle.class);
        startActivity(intent);
    }


    public void diceActivity(){
        Intent intent=new Intent(this,Dice.class);
        startActivity(intent);
    }

    public void notificationActivity(){
        Intent intent=new Intent(this,PushNotifications.class);
        startActivity(intent);
    }

    public void GameActivity(){
        Intent intent=new Intent(this,Game.class);
        startActivity(intent);
    }
}