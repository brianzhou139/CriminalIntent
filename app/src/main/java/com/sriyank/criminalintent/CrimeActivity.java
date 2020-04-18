package com.sriyank.criminalintent;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sriyank.criminalintent.fragments.CrimeFragment;
import com.sriyank.criminalintent.fragments.SingleFragmentClass;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentClass {

    private static final String EXTRA_CRIME_ID="com.sriyank.criminalintent_crime_id";

    public static Intent newIntent(Context context, UUID crimeId){
        Intent intent=new Intent(context,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID crimeId=(UUID)getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

}
