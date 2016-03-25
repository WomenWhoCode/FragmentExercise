package com.example.zassmin.fragmentexercise.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zassmin.fragmentexercise.R;

/**
 * Created by zassmin on 12/18/15.
 */
public class ColorFragment extends Fragment {
    private static final String COLOR_KEY = "color";
    private OnButtonClickListener listener;
    private View view;

    public interface OnButtonClickListener {
        void onButtonClickListener(int colorInt);
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
                RelativeLayout rl = (RelativeLayout) v.getParent();
                ColorDrawable colorDrawable = (ColorDrawable) rl.getBackground();
                listener.onButtonClickListener(colorDrawable.getColor());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        if (activity instanceof OnButtonClickListener) {
            listener = (OnButtonClickListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement ColorFragment.OnButtonClickListener");
        }
    }

    public void setBackgroundColor(int colorInt) {
        view.setBackgroundColor(colorInt);
    }
}
