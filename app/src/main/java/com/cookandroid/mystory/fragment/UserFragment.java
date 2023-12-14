package com.cookandroid.mystory.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cookandroid.mystory.LoginActivity;
import com.cookandroid.mystory.R;
import com.cookandroid.mystory.databinding.FragmentUserBinding;

public class UserFragment extends Fragment {

    FragmentUserBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        binding = DataBindingUtil.bind(view);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String nick = sharedPreferences.getString("nick","");
        String email = sharedPreferences.getString("email","");
        binding.nicktv.setText("닉네임 : " + nick + "");
        binding.emailtv.setText("이메일 : " + email + "");

        binding.btnlogout.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "클릭", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

}