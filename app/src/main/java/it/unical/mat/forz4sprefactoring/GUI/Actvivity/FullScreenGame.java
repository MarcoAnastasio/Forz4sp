package it.unical.mat.forz4sprefactoring.GUI.Actvivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import it.unical.mat.forz4sprefactoring.Core.Computer;
import it.unical.mat.forz4sprefactoring.Core.Human;
import it.unical.mat.forz4sprefactoring.Core.GameManager;
import it.unical.mat.forz4sprefactoring.GUI.Components.CustomCellColumn;
import com.example.haze.forzaQuattro.R;

import java.io.FileNotFoundException;

/**
 * Created by haze on 1/5/16.
 */
public class FullScreenGame extends Activity{
    private final int COLUMNS = 7;
    private GameManager manager;


     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_layout);
         LinearLayout grid= (LinearLayout) findViewById(R.id. cell_grid);
        manager = new GameManager(grid);
         manager.addPlayer(new Human("#C390D4",manager));
         try {
             manager.addPlayer(new Computer("#FFA500", manager));
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

         for(int i =0 ; i < COLUMNS ;++i){
            CustomCellColumn current_column = new CustomCellColumn(this,i,manager);
            grid.addView(current_column);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        manager.start();
    }
}
