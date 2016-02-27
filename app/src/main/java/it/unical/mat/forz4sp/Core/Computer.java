package it.unical.mat.forz4sp.Core;

import android.content.Context;

import it.unical.mat.forz4sp.Core.Facts.Chose_fact;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

import it.unical.mat.embasp.base.AnswerSet;
import it.unical.mat.embasp.base.AnswerSetCallback;
import it.unical.mat.embasp.base.AnswerSets;
import it.unical.mat.embasp.dlv.DLVHandler;
import it.unical.mat.embasp.mapper.ASPMapper;
import it.unical.mat.embasp.mapper.IllegalTermException;


public class Computer extends Player implements AnswerSetCallback {

    private DLVHandler handler;
    private Context context;
    private Random r = new Random();

    public Computer(String color, GameManager manager) throws FileNotFoundException {
        super(color, manager);
        handler = new DLVHandler();
        handler.setFilter("chose");
        context = manager.getContext();
        ASPMapper.getInstance().registerClass(Chose_fact.class);
        handler.addFileInput(getManager().getFilePath());
    }

    @Override
    public void addNewFact(Object fact) {
        try {
            handler.addInput(fact);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalTermException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeState() {
        super.changeState();
        if(getState())
        handler.start(context,this);
    }

    @Override
    public void callback(AnswerSets answerSets) {

        List<AnswerSet> result = answerSets.getAnswerSetsList();
        int High = result.size();
          System.out.println(High);
        int Result = 0;
        if (High > 1) {
            Result = r.nextInt(High);
        }

        try {
            Chose_fact fact = (Chose_fact) result.get(Result).getAnswerObjects().iterator().next();
            getManager().play(getColor(),fact);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
