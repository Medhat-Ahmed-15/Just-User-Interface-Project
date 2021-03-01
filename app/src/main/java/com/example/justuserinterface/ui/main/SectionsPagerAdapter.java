package com.example.justuserinterface.ui.main;

import android.content.Context;
import android.graphics.fonts.Font;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.justuserinterface.R;
import com.example.justuserinterface.Tab_1;
import com.example.justuserinterface.Tab_2;
import com.example.justuserinterface.Tab_3;




/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

   // @StringRes
    //private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new Tab_1();
            case 1:
                return new Tab_2();
            case 2:
                return new Tab_3();

            default:
                return null;
        }
    }


        @Nullable
        @Override
        public CharSequence getPageTitle ( int position){

            switch (position) {

                case 0:
                    return "scsdcx";
                case 1:
                    return "zzca";
                case 2:
                    return "zdscasdcx";

                default:
                    return null;
            }

        }

        @Override
        public int getCount () {
            // Show 2 total pages.
            return 3;
        }
    }