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
import android.widget.TextView;

public class BottomFragment extends Fragment{
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);

        textView=(TextView) view.findViewById(R.id.textView);

      return view;
    }

    public void recieveText (String top){

    textView.setText(top);

    }
}