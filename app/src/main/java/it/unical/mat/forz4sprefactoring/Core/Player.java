package it.unical.mat.forz4sprefactoring.Core;


public abstract class Player {

    private String color;
    private GameManager manager;
    private boolean turn = false;
    private int queue_number;


    public Player(String color,GameManager manager) {
        this.color = color;
        this.manager = manager;
        queue_number = 0;

    }

    public void setQueue_number(int queue_number){
        this.queue_number = queue_number;
    }

    public int getQueue_number(){
        return queue_number;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setManager(GameManager manager) {
        this.manager = manager;
    }

    public String getColor() {
        return color;
    }

    public GameManager getManager() {
        return manager;
    }


    public abstract void addNewFact(Object fact);

    public void changeState() {
        turn = !turn;
    }
    public boolean getState(){
        return turn;
    }


}
