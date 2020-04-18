package com.sriyank.criminalintent;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.sriyank.criminalintent.fragments.CrimeFragment;
import com.sriyank.criminalintent.fragments.SingleFragmentClass;

public class CrimeActivity extends SingleFragmentClass {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

}
