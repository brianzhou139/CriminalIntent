package com.sriyank.criminalintent.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sriyank.criminalintent.R;
import com.sriyank.criminalintent.data.CrimeLab;
import com.sriyank.criminalintent.models.Crime;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    public CrimeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView=(RecyclerView)v.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        updateUI();
        
        return v;
    }

    private void updateUI() {
        CrimeLab crimeLab=CrimeLab.get(getActivity());
        List<Crime> crimes=crimeLab.getCrimes();

        mAdapter=new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder>{

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=LayoutInflater.from(getActivity()).inflate(R.layout.list_item_crime,parent,false);
            return new CrimeViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CrimeViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        public class CrimeViewHolder extends RecyclerView.ViewHolder {
            public CrimeViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }



}
