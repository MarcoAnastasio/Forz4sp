package it.unical.mat.forz4sp.Core.Facts;

import it.unical.mat.embasp.mapper.Predicate;
import it.unical.mat.embasp.mapper.Term;

/**
 * Created by haze on 1/21/16.
 */

@Predicate("player")
public class Player_fact {
    @Term(0)
    private int number;

    public int getNumber() {
        return number;
    }

    public Player_fact() {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Player_fact(int number){
       this.number = number;
    }


}
