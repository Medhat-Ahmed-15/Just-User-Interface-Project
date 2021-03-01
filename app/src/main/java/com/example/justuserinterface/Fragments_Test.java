package com.example.justuserinterface;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Fragments_Test extends AppCompatActivity {

    Button fragment1Button;
    Button fragment2Button;
    Button backButton;

    ConstraintLayout cLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments__test);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        fragment1Button=(Button)findViewById(R.id.Fragment1_button);
        fragment2Button=(Button)findViewById(R.id.Fragment2_button);
        backButton=(Button)findViewById(R.id.back_button);



        fragment1Button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Drawable d = getResources().getDrawable(R.drawable.gradient_background2);
                cLayout.setBackground(d);
                Toast.makeText(Fragments_Test.this,"This is Fragment number 1",Toast.LENGTH_SHORT).show();
            }
        });


        fragment2Button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Drawable d = getResources().getDrawable(R.drawable.gradient_background4);
                cLayout.setBackground(d);
                Toast.makeText(Fragments_Test.this,"This is Fragment number 2 ",Toast.LENGTH_SHORT).show();
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