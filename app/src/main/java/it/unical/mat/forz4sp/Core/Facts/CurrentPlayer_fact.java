package it.unical.mat.forz4sp.Core.Facts;

import it.unical.mat.embasp.mapper.Predicate;
import it.unical.mat.embasp.mapper.Term;

@Predicate("current_player")
public class CurrentPlayer_fact {

    @Term(0)
    private int Number;

    public CurrentPlayer_fact(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        this.Number = number;
    }


    public CurrentPlayer_fact() {
    }
}
