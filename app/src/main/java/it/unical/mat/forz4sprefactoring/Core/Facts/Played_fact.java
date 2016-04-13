package it.unical.mat.forz4sprefactoring.Core.Facts;

import it.unical.mat.embasp.mapper.Predicate;
import it.unical.mat.embasp.mapper.Term;

/**
 * Created by haze on 1/21/16.
 */

@Predicate("played")
public class Played_fact {

    public int getColumn() {
        return Column;
    }

    public void setColumn(int column) {
        Column = column;
    }

    public int getPlayer() {
        return Player;
    }

    public void setPlayer(int player) {
        Player = player;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    @Term(0)
    private int Column;
    @Term(1)
    private int Row;
    @Term(2)
    private int Player;

    public Played_fact(int column, int row, int player) {
        Player= player;
        Column = column;
        Row = row;
    }


    public Played_fact(){

    }

    @Override
    public String toString() {
        return "Mossa C :"+ Column+" R :"+Row +" P:"+Player;
    }
}
