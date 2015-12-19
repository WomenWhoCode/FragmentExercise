package com.example.zassmin.fragmentexercise.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zassmin.fragmentexercise.R;

/**
 * Created by zassmin on 12/18/15.
 */
public class ColorFragment extends Fragment {
    private static final String COLOR_KEY = "color";
    private OnButtonClickListener listener;
    private View view;
    private int colorInt;
    private String color;

    public interface OnButtonClickListener {
        void onButtonClickListener(String hexColor, int colorInt);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_color, container, false);

        // button click listener
        Button btnColorful = (Button) view.findViewById(R.id.btnColorful);
        btnColorful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonClickListener(color, colorInt);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnButtonClickListener) {
            listener = (OnButtonClickListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement ColorFragment.OnButtonClickListener");
        }
    }

    public void setColor(String colorHex) {
        // set color
        TextView tvColorful = (TextView) view.findViewById(R.id.tvColorful);
        color = colorHex;
        colorInt = Color.parseColor(color);
        tvColorful.setBackgroundColor(colorInt);
    }
}
