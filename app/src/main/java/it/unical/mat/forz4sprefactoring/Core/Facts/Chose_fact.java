package it.unical.mat.forz4sprefactoring.Core.Facts;


import it.unical.mat.embasp.mapper.Predicate;
import it.unical.mat.embasp.mapper.Term;

@Predicate("chose")
public class Chose_fact {

    @Term(0)
    private int Column;
    @Term(1)
    private int Row;
    @Term(2)
    private int Player;

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public int getPlayer() {
        return Player;
    }

    public void setPlayer(int player) {
        Player = player;
    }

    public Chose_fact() {
    }

    public Chose_fact(int column, int row,int player) {
        Column = column;
        Player = player;
        Row = row;
    }

    public int getColumn() {
        return Column;
    }

    public void setColumn(int column) {
        Column = column;
    }

    public Played_fact toPlayed(){
       return  new Played_fact(Column,Row,Player);
    }

    @Override
    public String toString() {
        return "MossaPC C :"+ Column+" R :"+Row +" P:"+Player;
    }
}
