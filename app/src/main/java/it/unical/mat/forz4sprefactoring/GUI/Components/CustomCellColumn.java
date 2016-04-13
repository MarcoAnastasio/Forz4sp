package it.unical.mat.forz4sprefactoring.GUI.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import it.unical.mat.forz4sprefactoring.Core.GameManager;

/**
 * Created by haze on 1/6/16.
 */
public class CustomCellColumn extends LinearLayout implements View.OnClickListener {
    private final int ROWS =6;
    private int last_selection =5;
    private final int COLUMN;
    private Context context;
    private GameManager manager;

    public CustomCellColumn(Context context , int column, GameManager manager) {
        super(context);
        COLUMN = column;
        init();
        setOnClickListener(this);
        setOrientation(VERTICAL);
        this.manager = manager;
    }



    private void init() {
        for(int i =0 ;i < ROWS ;++i){
            addView(new CustomCell(getContext()));
        }
    }

    public void setPlayerSelection(String c){
        if(last_selection >= 0)
        ((CustomCell)getChildAt(last_selection--)).usedCell(c);
    }

    public int getCOLUMN(){
        return COLUMN;
    }

    public int getROW(){ return last_selection;    }

    @Override
    public void onClick(View v) {
    manager.click(getCOLUMN(),last_selection);

    }
}
