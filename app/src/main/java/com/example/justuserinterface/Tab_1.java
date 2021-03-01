package com.example.justuserinterface;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class Tab_1 extends Fragment {

    ConstraintLayout tabView;

    Button call_button;
    Button sendSMS_button;
    Button insert_button;

    EditText editTextPhone;
    EditText editTextTextEmailAddress;
    EditText address_editText;;
    EditText name_editText;
    EditText message_editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_1,container,false);

        tabView=(ConstraintLayout) v.findViewById(R.id.tabView);

        editTextPhone=(EditText) v.findViewById(R.id.editTextPhone);
        editTextTextEmailAddress=(EditText) v.findViewById(R.id.editTextTextEmailAddress);
        address_editText=(EditText) v.findViewById(R.id.address_editText);
        name_editText=(EditText) v.findViewById(R.id.name_editText);
        message_editText=(EditText) v.findViewById(R.id.message_editText);
        call_button=(Button) v.findViewById(R.id.call_button);
        sendSMS_button=(Button) v.findViewById(R.id.sendSMS_button);
        insert_button=(Button) v.findViewById(R.id.insert_button);


        AnimationDrawable animationDrawable=(AnimationDrawable) tabView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();





        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=editTextPhone.getText().toString();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);//tafr2 eih action dial mn action call 3ashan action call msh sha8ala 3andee????????????????????
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);

            }
        });


        sendSMS_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("smsto:"));
                i.putExtra("address", editTextPhone.getText().toString());
                i.putExtra("sms_body","EMERGENCY");

                    startActivity(i);

                 /*Intent s=new Intent(Intent.ACTION_SENDTO);
                 s.setData(Uri.parse("mailto:"));
                 s.putExtra(Intent.EXTRA_EMAIL,editTextTextEmailAddress.getText().toString());
                 s.putExtra(Intent.EXTRA_TEXT,"WELCOME");
                 startActivity(s);*/

            }
        });


        insert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
                intent.setType(ContactsContract.Contacts.CONTENT_ITEM_TYPE);

                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, editTextTextEmailAddress.getText().toString())
                        .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.PHONE, editTextPhone.getText())
                        .putExtra(ContactsContract.Intents.Insert.NAME, name_editText.getText().toString())
                        .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);


                startActivity(intent);

            }
        });








        return v;
    }


}
