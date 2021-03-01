package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;

public class GesturesAndFragments extends AppCompatActivity implements TopFragment.TopSectionListner,GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    ConstraintLayout cLayout;

    Button back;

    TextView gestureTextView;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures_and_fragments);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        back=(Button)findViewById(R.id.back_button);
        gestureTextView=(TextView) findViewById(R.id.gestureTextView);


        this.gestureDetector=new GestureDetector(this,this);
        gestureDetector.setOnDoubleTapListener(this);




        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();









        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    public void back(){
        Intent intent=new Intent(this,Mobille_Application_Assignment.class);
        startActivity(intent);
    }
//THIS METHOD CALLED WHEN BUTTON SWITCH IS PRESSED
    @Override
    public void createMeme(String Top) {

BottomFragment bottomFragment=(BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
bottomFragment.recieveText(Top);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        gestureTextView.setText("I SEE YOU JUST MADE A SINGLE TAP🙃");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        gestureTextView.setText("NOW YOU DOUBLE TAPPED...MY MAN😎");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        gestureTextView.setText("WEEEEE😵🤪");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        gestureTextView.setText("DUDE..STOP PRESSING ME 😡🤬");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        gestureTextView.setText("IS THIS JUST A FLING  YOU MADE 🤨");
        return true;
    }
}