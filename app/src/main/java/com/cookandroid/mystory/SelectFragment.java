package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        String[] item = {"원", "투", "쓰리", "포", "원", "투", "쓰리", "포", "원", "투", "쓰리", "포", "원", "투", "쓰리", "포", "원", "투", "쓰리", "포"};

        ArrayAdapter<String> list = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                list.getFilter().filter(newText);

                listview2.setAdapter(list);

                return false;

            }
        });


        return view;
    }
}