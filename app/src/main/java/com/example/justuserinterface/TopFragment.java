package com.example.justuserinterface;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.widget.Button;
import android.widget.EditText;


public class TopFragment extends Fragment {

    Button switchButton;
    EditText editTextTop;


    TopSectionListner activityCommander;

    public interface  TopSectionListner{

        public void createMeme(String Top);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        activityCommander=(TopSectionListner) activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.top_fragment,container,false);

        switchButton=(Button) view.findViewById(R.id.switch_button);
        editTextTop=(EditText) view.findViewById(R.id.editTextTop);





        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchButtonClicked();
            }
        });
       return  view;
    }

    public void switchButtonClicked(){

        activityCommander.createMeme(editTextTop.getText().toString());

    }
}
