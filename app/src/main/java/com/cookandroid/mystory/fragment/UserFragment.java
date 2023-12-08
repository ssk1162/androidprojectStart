package com.cookandroid.mystory.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.mystory.LoginActivity;
import com.cookandroid.mystory.R;

public class UserFragment extends Fragment {

    TextView nicktv, emailtv;
    Button btnlogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        nicktv = view.findViewById(R.id.nicktv);
        emailtv = view.findViewById(R.id.emailtv);
        btnlogout = view.findViewById(R.id.btnlogout);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String nick = sharedPreferences.getString("nick","");
        String email = sharedPreferences.getString("email","");
        nicktv.setText("닉네임 : " + nick);
        emailtv.setText("이메일 : " + email);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "클릭", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}