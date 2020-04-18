package com.sriyank.criminalintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.sriyank.criminalintent.fragments.CrimeListFragment;
import com.sriyank.criminalintent.fragments.SingleFragmentClass;

public class CrimeListActivity extends SingleFragmentClass {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
