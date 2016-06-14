package com.pedro.aplicacaopoo2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pedro.aplicacaopoo2.R;

/**
 * Created by pedro on 01/06/16.
 */
public class FragmentTables extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tables,container,false);

        return view;
    }
}
