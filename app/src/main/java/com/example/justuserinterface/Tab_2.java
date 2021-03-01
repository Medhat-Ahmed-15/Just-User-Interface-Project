package com.example.justuserinterface;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class Tab_2 extends Fragment {
    ConstraintLayout tabView;

    Button visitOurWebsite_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab_2,container,false);

        tabView=(ConstraintLayout) v.findViewById(R.id.tabView);

        visitOurWebsite_button=(Button) v.findViewById(R.id.visitOurWebsite_button);




        AnimationDrawable animationDrawable=(AnimationDrawable) tabView.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();



        visitOurWebsite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url="https://pixabay.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
               startActivity(i);

            }
        });


        return v;
    }


}
