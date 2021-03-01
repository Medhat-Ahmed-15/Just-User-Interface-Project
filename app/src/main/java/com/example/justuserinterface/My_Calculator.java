package com.example.justuserinterface;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class My_Calculator extends AppCompatActivity {

    ConstraintLayout cLayout;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button multiply;
    Button divide;
    Button plus;
    Button minus;
    Button equal;
    Button back;

    EditText input;

    boolean flagAdd;
    boolean flagSub;
    boolean flagDivide;
    boolean flagMult;

    int value1;
    int value2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__calculator);

        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);

        zero=(Button)findViewById(R.id.button_0);
        one=(Button)findViewById(R.id.button_1);
        two=(Button)findViewById(R.id.button_2);
        three=(Button)findViewById(R.id.button_3);
        four=(Button)findViewById(R.id.button_4);
        five=(Button)findViewById(R.id.button_5);
        six=(Button)findViewById(R.id.button_6);
        seven=(Button)findViewById(R.id.button_7);
        eight=(Button)findViewById(R.id.button_8);
        nine=(Button)findViewById(R.id.button_9);
        multiply=(Button)findViewById(R.id.button_multiply);
        divide=(Button)findViewById(R.id.button_divide);
        plus=(Button)findViewById(R.id.button_plus);
        minus=(Button)findViewById(R.id.button_minus);
        equal=(Button)findViewById(R.id.button_equal);
        back=(Button)findViewById(R.id.back_button);
        input=(EditText) findViewById(R.id.input_textField);





        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("8");
            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("9");
            }
        });


        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input == null) { Toast.makeText(My_Calculator.this,"PLEASE ENTER A NUMBER",Toast.LENGTH_LONG).show();}

                else{
                    value1= Integer.parseInt(input.getText().toString());
                    flagDivide=true;
                    input.setText(null);
                }

            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input == null) { Toast.makeText(My_Calculator.this,"PLEASE ENTER A NUMBER",Toast.LENGTH_LONG).show();}

                else{
                    value1= Integer.parseInt(input.getText().toString());
                    flagMult=true;
                    input.setText(null);
                }
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input == null) { Toast.makeText(My_Calculator.this,"PLEASE ENTER A NUMBER",Toast.LENGTH_LONG).show();}

                else{
                    value1= Integer.parseInt(input.getText().toString());
                    flagAdd=true;
                    input.setText(null);
                }
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input == null) { Toast.makeText(My_Calculator.this,"PLEASE ENTER A NUMBER",Toast.LENGTH_LONG).show();}

                else{
                    value1= Integer.parseInt(input.getText().toString());
                    flagSub=true;
                    input.setText(null);
                }
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value2= Integer.parseInt(input.getText().toString());

                if(flagDivide==true){//divide
                    input.setText(value1 / value2 + "");
                    flagDivide = false;
                }
                 if(flagMult==true){//multiply
                     input.setText(value1*value2 + "");
                     flagMult = false;
                }

                 if(flagAdd==true){//plus

                     input.setText(value1 + value2 + "");
                     flagAdd = false;
                }

                 if(flagSub==true){//minus

                     input.setText(value1 - value2 + "");
                     flagSub = false;
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
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