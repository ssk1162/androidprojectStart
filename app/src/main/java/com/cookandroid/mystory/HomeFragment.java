package com.cookandroid.mystory;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ListView listview = view.findViewById(R.id.listview);

        String[] item = {"원","투","쓰리","포"};

        ArrayAdapter<String> list = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, item);

        listview.setAdapter(list);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                Bundle result = new Bundle();
//                result.putString("data", list.getItem(i));
//
//                Toast.makeText(getActivity(), result.getString("data"), Toast.LENGTH_SHORT).show();
//                ItemFragment itemFragment = new ItemFragment();
//                itemFragment.setArguments(result);
//
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_result, itemFragment).commit();

                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);

                Toast.makeText(getActivity(), (i + 1) + "번째 클릭", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}