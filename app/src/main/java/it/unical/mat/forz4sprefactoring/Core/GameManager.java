package it.unical.mat.forz4sprefactoring.Core;

import android.content.Context;
import android.widget.LinearLayout;

import it.unical.mat.embasp.base.Output;
import it.unical.mat.forz4sprefactoring.Core.Facts.Chose_fact;
import it.unical.mat.forz4sprefactoring.Core.Facts.CurrentPlayer_fact;
import it.unical.mat.forz4sprefactoring.Core.Facts.Played_fact;
import it.unical.mat.forz4sprefactoring.Core.Facts.Player_fact;
import it.unical.mat.forz4sprefactoring.GUI.Components.CustomCellColumn;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import it.unical.mat.embasp.base.Callback;

public class GameManager implements onColumnClick , Callback{

    private int current_player=0;
    private LinearLayout grid;
    private int program_index;
    private AndroidHandler handler;
    private File logic_file;
    private String color_player_1 = "#C390D4" ;
    private String color_player_2 = "#FFA500" ;
    private Context context;
    public final String logic_filename="computer_logic.asp";
    private boolean finished;
    private final int ROWS = 6;
    private final int COLUMNS = 7;

    public GameManager(LinearLayout grid) {
        this.grid = grid;
        context = grid.getContext();
        finished = false;
        init();
    }

    private void init() {
        String logic_filename = "computer_logic.asp";
        logic_file = new File(context.getFilesDir()+"/" + logic_filename);
        logic_file.delete();
        if(!logic_file.exists()){
            try {
                InputStream is = context.getAssets().open(logic_filename);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                FileOutputStream fos = new FileOutputStream(logic_file);
                fos.write(buffer);
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ConcreteInputProgram program = new ConcreteInputProgram();

        program.addFilesPath(logic_file.getPath());

        program.addRawInput("player(0)");

       program_index = handler.addProgram(program);

    }


    public String getFilePath(){
        return logic_file.getPath();
    }


    public void start(){

    }


    public void play(String Color , Object facts){
        players.get(current_player).changeState();
        Chose_fact have_chosen = (Chose_fact) facts;
        Played_fact newPlay = have_chosen.toPlayed();
        System.out.println(newPlay.toString());
        int Column = newPlay.getColumn();
        int Row = newPlay.getRow();
        int player = newPlay.getPlayer();
        CustomCellColumn c = (CustomCellColumn) grid.getChildAt(Column);
        newFact(new Played_fact(Column,Row,player));
        c.setPlayerSelection(Color);
        nextPLayer();
    }



    public void newFact(Object fact){
    }


    public Context getContext() {
        return grid.getContext();
    }

    public int getCurrentPlayer() {
        return current_player;
    }

    @Override
    public void click(int Column,int Row) {
        ConcreteInputProgram c = handler.getInputProgram(program_index);

        //TODO with objects
        c.addRawInput(new Played_fact(Column, Row, current_player).toString());

        CustomCellColumn c = (CustomCellColumn)grid.getChildAt(Column);

        switch(current_player) {
            case 0:   c.setPlayerSelection(color_player_1); break;
            case 1:   c.setPlayerSelection(color_player_2); break;
        }

        handler.startAsync(new ArrayList<Integer>() ,new ArrayList<Integer>(),this);

    }

    private void nextPLayer(){

    }

    @Override
    public void callback(Output o) {

    }
}
