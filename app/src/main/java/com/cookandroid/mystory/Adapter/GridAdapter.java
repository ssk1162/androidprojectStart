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

    // 초기화
    public GridAdapter(Context context, String[] arrNumberWord, int[] arrNumberImage) {
        this.context = context;
        this.arrNumberImage = arrNumberImage;
        this.arrNumberWord = arrNumberWord;
    }

    // 아이템의 총 개수
    @Override
    public int getCount() {
        return arrNumberWord.length;
    }

    // 아이템 이름을 순서대로 넣기
    @Override
    public Object getItem(int i) {
        return arrNumberWord[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // 뷰를 생성하거나 재활용하기 위한 부분
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 메모리 사용량을 줄이기 위한 부분
        // (LayoutInflater) xml에 정의한 레이아웃을 실제 뷰 객체로 인스턴스화 하는데 사용
        // inflater 초기화 되지 않았으면 context를 이용하여 (LayoutInflater)를 얻어와 초기화
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        // view가 null이면 재활용할 뷰가 없으므로 R.layout.grid_layout 기반으로 새로운 뷰를 생성
        if (view == null) {
            view = inflater.inflate(R.layout.grid_layout, null);
        }

        ImageView numberImage = view.findViewById(R.id.img);
        TextView numberWord = view.findViewById(R.id.imgtv);
        // 이미지와 이름 설정
        numberImage.setImageResource(arrNumberImage[i]);
        numberWord.setText(arrNumberWord[i]);

        return view;
    }

}
