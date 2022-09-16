package com.rayyantech.poets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.PagerAdapter;

import com.rayyantech.poets.R;

public class SliderAdapter extends PagerAdapter {

    private final Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    // here is all images that is used on onBoarding sliders
    int[] images = {
            R.drawable.on_boarding_first_slider,
            R.drawable.on_boarding_second_slider,
            R.drawable.on_boarding_third_slider,
            R.drawable.on_boarding_fourth_slider
    };

    // here is all heading texts that is used on onBoarding sliders
    int[] headings = {
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title,
            R.string.fourth_slide_title
    };

    // here is all descriptions texts that is used on onBoarding sliders
    int[] descriptions = {
            R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
            R.string.fourth_slide_desc,
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_slides, container, false);
        AppCompatImageView imageView = view.findViewById(R.id.layout_slides_image_view_slider);
        AppCompatTextView heading = view.findViewById(R.id.layout_slides_text_view_slider_heading);
        AppCompatTextView desc = view.findViewById(R.id.layout_slides_text_view_slider_description);
        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
