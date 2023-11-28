package com.cookandroid.mystory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookandroid.mystory.R;

public class GridAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    String[] arrNumberWord;
    int[] arrNumberImage;

    public GridAdapter(Context context, String[] arrNumberWord, int[] arrNumberImage) {
        this.context = context;
        this.arrNumberImage = arrNumberImage;
        this.arrNumberWord = arrNumberWord;
    }

    @Override
    public int getCount() {
        return arrNumberWord.length;
    }

    @Override
    public Object getItem(int i) {
        return arrNumberWord[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = inflater.inflate(R.layout.grid_layout, null);
        }

        ImageView numberImage = view.findViewById(R.id.img);
        TextView numberWord = view.findViewById(R.id.imgtv);

        numberImage.setImageResource(arrNumberImage[i]);
        numberWord.setText(arrNumberWord[i]);

        return view;
    }

}
