package com.example.justuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.defaults.colorpicker.ColorPickerPopup;

public class ColorPicker extends AppCompatActivity {

    ConstraintLayout cLayout;

    Button changeBackgroundColor_button;
    Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);

        changeBackgroundColor_button=(Button)findViewById(R.id.changeBackgroundColor_button);
        back_button=(Button)findViewById(R.id.back_button);

        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        changeBackgroundColor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new ColorPickerPopup.Builder(ColorPicker.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(view, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                cLayout.setBackgroundColor(color);
                            }

                        });

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
}