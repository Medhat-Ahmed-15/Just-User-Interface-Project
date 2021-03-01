package com.example.justuserinterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.net.URI;

public class Signup_Page extends AppCompatActivity {

    ConstraintLayout cLayout;

    Uri uri;

    ImageView imageView;

    Button backButton;
    Button choosePicture_button;
    Button signup_button;
    Button restore_button;

    EditText firstName_textField;
    EditText secondName_textField;
    EditText email_textField;
    EditText password_textField;

    String firstName1;
    String sirName1;
    String email1;
    String passWord1;

    int flag;

    DatabaseReference databaseReferenceUsers;
    DatabaseReference databaseReferenceEvents;

    Users users;
    Events events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__page);


        cLayout=(ConstraintLayout) findViewById(R.id.cLayout);
        backButton=(Button)findViewById(R.id.back_button);
        choosePicture_button=(Button)findViewById(R.id.choosePicture_button);
        restore_button=(Button)findViewById(R.id.restore_button);

        firstName_textField=(EditText) findViewById(R.id.firstName_textField);
        secondName_textField=(EditText) findViewById(R.id.secondName_textField);
        email_textField=(EditText) findViewById(R.id.email_textField);
        password_textField=(EditText) findViewById(R.id.password_textField);

        signup_button=(Button)findViewById(R.id.signup_button);
        imageView=(ImageView) findViewById(R.id.imageView);

        databaseReferenceUsers=FirebaseDatabase.getInstance().getReference().child("USERS");
        databaseReferenceEvents=FirebaseDatabase.getInstance().getReference().child("EVENTS");
        users=new Users();
        events=new Events();

        AnimationDrawable animationDrawable=(AnimationDrawable) cLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();




        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });


        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //keda 2a5r haga ana wasaltalha 2nee law tala3t dol 👇 bara el button hatb2 fadya fal firabase ma3 2n rl mafrood tab2 haya haya lama
                // 2atal3ha bs howa keda
                firstName1=firstName_textField.getText().toString();
                sirName1=secondName_textField.getText().toString();
                email1=email_textField.getText().toString();
                passWord1=password_textField.getText().toString();

                users.setFirstName(firstName1);
                users.setSirName(sirName1);
                users.setEmail(email1);
                users.setPassWord(passWord1);

                events.setDate("23/4");
                events.setPlace("hilton");
                events.setType("wedding");

                databaseReferenceUsers.push().setValue(users);
                databaseReferenceEvents.push().setValue(events);



            }
        });


        restore_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReferenceUsers=FirebaseDatabase.getInstance().getReference().child("USERS").child("user1");
                databaseReferenceUsers.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String firstname=snapshot.child("firstName").getValue().toString();
                        String secondname=snapshot.child("sirName").getValue().toString();
                        String email=snapshot.child("email").getValue().toString();

                        firstName_textField.setText(firstname);
                        secondName_textField.setText(secondname);
                        email_textField.setText(email);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        if(!HasCamera()){
            Toast.makeText(Signup_Page.this,"PLEASE MAKE SURE THAT YOU HAVE A CAMERA❗❗❗",Toast.LENGTH_LONG).show();
        }


        choosePicture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==DialogInterface.BUTTON_POSITIVE){//dee bat return akeed rakam integer el howa int which masaln 1
                                //CHOOSE FROM LIBRARY button clicked
                                Intent intent1=new Intent();
                                intent1.setAction(Intent.ACTION_GET_CONTENT);
                                intent1.setType("image/*");
                                flag=1;
                                startActivityForResult(intent1,1);}


                        if(which==DialogInterface.BUTTON_NEGATIVE){//dee bat return akeed rakam integer el howa int which masaln -1
                                //TAKE PHOTO button clicked
                                Intent intent2=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                flag=2;
                                startActivityForResult(intent2,2);}

                    }
                };

                //here we build the texts that gonna be written in the interface of the alert box
                AlertDialog.Builder builder = new AlertDialog.Builder(Signup_Page.this);
                builder.setMessage("").setPositiveButton("CHOOSE FROM LIBRARY🗂", dialogClickListener)
                        .setNegativeButton("TAKE PHOTO📸", dialogClickListener).show();


            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(flag==1) {

            if (requestCode == 1 && resultCode == RESULT_OK) {
                uri = data.getData();


                try {

                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    imageView.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        else{


            if (requestCode == 2 && resultCode == RESULT_OK) {
                Bundle extras=data.getExtras();
                Bitmap photo=(Bitmap) extras.get("data");
                imageView.setImageBitmap(photo);

            }




        }


    }

    private boolean HasCamera()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }


    public void openMainActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}