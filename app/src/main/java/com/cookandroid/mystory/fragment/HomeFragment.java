package com.cookandroid.mystory.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.mystory.MainActivity;
import com.cookandroid.mystory.R;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("메인");

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }



}