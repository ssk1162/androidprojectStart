package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("메인");

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ListView listview = view.findViewById(R.id.listview);

        String[] item = {"원","투","쓰리","포"};

        ArrayAdapter<String> list = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, item);

        listview.setAdapter(list);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getContext(), ItemActivity.class);
                intent.putExtra("data", list.getItem(i));
                startActivity(intent);

                Toast.makeText(getActivity(), list.getItem(i)+ " 클릭", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}