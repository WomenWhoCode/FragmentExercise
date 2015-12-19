package com.example.zassmin.fragmentexercise.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zassmin.fragmentexercise.R;

/**
 * Created by zassmin on 12/18/15.
 */
public class ColorFragment extends Fragment {
    private static final String COLOR_KEY = "color";

    public static ColorFragment newInstance(String color) {
        ColorFragment colorFragment = new ColorFragment();
        Bundle args = new Bundle();
        args.putString(COLOR_KEY, color);
        colorFragment.setArguments(args);
        return colorFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);

        // set color
        TextView tvColorful = (TextView) view.findViewById(R.id.tvColorful);
        String color = getArguments().getString(COLOR_KEY, "#00b5a9"); // fallback
        int colorInt = Color.parseColor(color);
        tvColorful.setBackgroundColor(colorInt);

        return view;
    }
}
