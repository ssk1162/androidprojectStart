package com.cookandroid.mystory.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cookandroid.mystory.Adapter.GridAdapter;
import com.cookandroid.mystory.ItemActivity;
import com.cookandroid.mystory.R;
import com.cookandroid.mystory.Adapter.SliderAdapter;
import com.cookandroid.mystory.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ViewPager2 viewPager2;
    private Handler sliderHendler = new Handler();
    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager2 = view.findViewById(R.id.viewPageImageSlider);
        gridView = view.findViewById(R.id.gridview);

        sliderview();
        itemview();

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHendler.removeCallbacks(sliderRunnable);
                sliderHendler.postDelayed(sliderRunnable, 3000);
            }
        });

        return view;
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHendler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHendler.postDelayed(sliderRunnable, 3000);

    }

    private void sliderview() {
        List<SliderItem> sliderItems = new ArrayList<>();

        sliderItems.add(new SliderItem(R.drawable.image));
        sliderItems.add(new SliderItem(R.drawable.image2));
        sliderItems.add(new SliderItem(R.drawable.image3));
        sliderItems.add(new SliderItem(R.drawable.image4));
        sliderItems.add(new SliderItem(R.drawable.image5));
        sliderItems.add(new SliderItem(R.drawable.image6));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

    }

    private void itemview() {

        String[] numberWord = {"one","two","three","four","five","six","one","two","three","four","five","six","one","two","three","four","five","six"};
        int[] numberImage = {R.drawable.image,R.drawable.image2,R.drawable.image3,
                R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image,R.drawable.image2,R.drawable.image3,
                R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image,R.drawable.image2,R.drawable.image3,
                R.drawable.image4,R.drawable.image5,R.drawable.image6};
        GridAdapter gridAdapter = new GridAdapter(getActivity(), numberWord, numberImage);

        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), ItemActivity.class);
                intent.putExtra("word", numberWord[i]);
                intent.putExtra("img", numberImage[i]);
                startActivity(intent);

            }
        });

    }

}