package it.unical.mat.forz4sprefactoring.GUI.Actvivity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import it.unical.mat.forz4sprefactoring.GUI.Components.SingleButtonFragment;
import it.unical.mat.forz4sprefactoring.GUI.Components.TripleButtonFragment;
import com.example.haze.forzaQuattro.R;

public class MainScreen extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        if (savedInstanceState != null) {
            return;
        }
        SingleButtonFragment fragment = new SingleButtonFragment();
        Bundle args = new Bundle();
        args.putString(SingleButtonFragment.ARG,"Gioca");
        fragment.setArguments(args);

        getFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
    }


    public void play_button(View view) {

        TripleButtonFragment difficultButtons = new TripleButtonFragment();
        Bundle args = new Bundle();
        args.putString(TripleButtonFragment.first_button,"Facile");
        args.putString(TripleButtonFragment.second_button,"Normale");
        args.putString(TripleButtonFragment.third_button,"Difficile");
        difficultButtons.setArguments(args);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, difficultButtons).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() !=0) {
            getFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }

    }

    public void playGame (View view){

        Intent intent = new Intent(this,FullScreenGame.class);
        startActivity(intent);

    }
}
