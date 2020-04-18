package com.sriyank.criminalintent.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sriyank.criminalintent.R;

public abstract class SingleFragmentClass extends AppCompatActivity {
    //This is a smart move guys yeah
    //This is a smart move guys yeah

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm=getSupportFragmentManager();
        Fragment frag=fm.findFragmentById(R.id.fragment_container);

        if(frag==null){
            frag=createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,frag)
                    .commit();

        }


    }
}
