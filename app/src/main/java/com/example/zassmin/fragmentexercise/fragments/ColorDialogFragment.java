package com.example.zassmin.fragmentexercise.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by zassmin on 12/19/15.
 */
public class ColorDialogFragment extends DialogFragment {
    private static final String COLOR_INT_KEY = "color_int";

    public ColorDialogFragment() {
        // Empty constructor required for DialogFragment
    }

    public static ColorDialogFragment newInstance(int colorInt) {
        ColorDialogFragment frag = new ColorDialogFragment();
        Bundle args = new Bundle();
        args.putInt(COLOR_INT_KEY, colorInt);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int colorInt = getArguments().getInt(COLOR_INT_KEY, 0);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Colors are...");
        alertDialogBuilder.setMessage("int color: " + colorInt);
        alertDialogBuilder.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();
    }
}
