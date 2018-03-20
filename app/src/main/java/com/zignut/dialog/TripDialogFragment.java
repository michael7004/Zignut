package com.zignut.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.zignut.R;


/**
 * Created by unepali on 1/11/2018.
 */

public class TripDialogFragment extends DialogFragment {

    private EditText etTrinName;

    private FragmentManager fragmentManager;

    public OnCompleteListener mListener;

    // make sure the Activity implemented it
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnCompleteListener) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.fragment_dialog_trip);
        fragmentManager = getFragmentManager();

        //these two line is used to open softkeyboard when fragment open
        InputMethodManager inputMananger = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMananger.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        etTrinName = (EditText) dialog.findViewById(R.id.et_trip_name);

        /*
        * Start trip when clicking the button
        * */
        dialog.findViewById(R.id.bnt_start_trip).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                String time = etTrinName.getText().toString().trim();
                mListener.onComplete(time);
                dismiss();


            }

        });


        return dialog;

    }

    public static interface OnCompleteListener {
        public abstract void onComplete(String time);
    }

}
