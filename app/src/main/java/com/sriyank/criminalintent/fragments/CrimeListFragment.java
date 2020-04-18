package com.sriyank.criminalintent.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sriyank.criminalintent.CrimeActivity;
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

        if(mAdapter==null){
            mAdapter=new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }

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
            Crime crime=mCrimes.get(position);
            holder.Bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        public class CrimeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private TextView mTitleTextView;
            private TextView mDateTextView;
            private ImageView mSolvedImageView;

            private Crime mCrime;

            public CrimeViewHolder(@NonNull View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);

                mTitleTextView=(TextView)itemView.findViewById(R.id.crime_title);
                mDateTextView=(TextView)itemView.findViewById(R.id.crime_date);
                mSolvedImageView=(ImageView) itemView.findViewById(R.id.crime_solved);
            }

            public void Bind(Crime crime){
                mCrime=crime;
                mTitleTextView.setText(mCrime.getTitle());
                mDateTextView.setText(mCrime.getDate().toString());

                mSolvedImageView.setVisibility(crime.isSolved() ? View.VISIBLE: View.GONE);

            }

            @Override
            public void onClick(View view) {
                Intent intent=CrimeActivity.newIntent(getActivity(),mCrime.getId());
                startActivity(intent);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
