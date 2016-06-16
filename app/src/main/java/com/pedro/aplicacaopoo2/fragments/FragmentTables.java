package com.pedro.aplicacaopoo2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedro.aplicacaopoo2.R;
import com.pedro.aplicacaopoo2.adapters.AdapterTables;
import com.pedro.aplicacaopoo2.model.Table;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pedro on 01/06/16.
 */
public class FragmentTables extends Fragment {

    @Bind(R.id.rv_tables)
    RecyclerView mTablesRecyclerView;

    private RecyclerView.LayoutManager mTablesLayoutManager;
    private AdapterTables mAdapterTables;
    private ArrayList<Table> mTables = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tables,container,false);
        ButterKnife.bind(this,view);

        mTables.add(new Table("1","5"));
        mTablesLayoutManager = new LinearLayoutManager(getActivity());
        mTablesRecyclerView.setLayoutManager(mTablesLayoutManager);

        mAdapterTables = new AdapterTables();
        mAdapterTables.setTables(mTables);
        mTablesRecyclerView.setAdapter(mAdapterTables);

        return view;
    }


}
