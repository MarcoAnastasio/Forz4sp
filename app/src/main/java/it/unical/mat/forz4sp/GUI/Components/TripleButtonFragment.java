package it.unical.mat.forz4sp.GUI.Components;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.haze.forzaQuattro.R;

/**
 * Created by haze on 12/23/15.
 */
public class TripleButtonFragment extends Fragment {
    public final static String first_button = "first_button";
    public final static String second_button = "second_button";
    public final static String third_button = "third_button";


    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args!= null){
            ((Button) getActivity().findViewById(R.id.button1)).setText(args.getString(first_button));
            ((Button) getActivity().findViewById(R.id.button2)).setText(args.getString(second_button));
            ((Button) getActivity().findViewById(R.id.button3)).setText(args.getString(third_button));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.triple_fragment_layout, container, false);
    }




}