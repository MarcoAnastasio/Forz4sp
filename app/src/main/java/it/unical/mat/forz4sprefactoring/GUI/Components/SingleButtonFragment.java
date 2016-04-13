package it.unical.mat.forz4sprefactoring.GUI.Components;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.haze.forzaQuattro.R;

/**
 * Created by haze on 12/21/15.
 */
public class SingleButtonFragment extends Fragment {
    public final static String ARG = "button_text";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if(args != null){
            ((Button) getActivity().findViewById(R.id.button)).setText(args.getString(ARG));
        }
    }


}
