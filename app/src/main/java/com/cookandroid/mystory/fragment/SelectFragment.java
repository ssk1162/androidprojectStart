package com.cookandroid.mystory.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cookandroid.mystory.MainActivity;
import com.cookandroid.mystory.R;

public class SelectFragment extends Fragment {

    ListView listview2;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("검색");

        View view = inflater.inflate(R.layout.fragment_select, container, false);

        listview2 = view.findViewById(R.id.listview2);
        searchView = view.findViewById(R.id.searchView);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;

            }
        });


        return view;
    }
}