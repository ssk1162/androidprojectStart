package com.cookandroid.mystory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserFragment extends Fragment {

    TextView usertv, emailtv;
    Button btnlogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("마이페이지");

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        usertv = view.findViewById(R.id.usertv);
        emailtv = view.findViewById(R.id.emailtv);
        btnlogout = view.findViewById(R.id.btnlogout);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("user","");
        String email = sharedPreferences.getString("email","");
        usertv.setText("아이디 : " + user);
        emailtv.setText("이메일 : " + email);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "클릭", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}