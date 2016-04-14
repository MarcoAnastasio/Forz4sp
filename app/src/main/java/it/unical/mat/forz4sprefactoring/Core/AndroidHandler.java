package it.unical.mat.forz4sprefactoring.Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Service;
import it.unical.mat.embasp.dlv.AndroidDLVSerice;

/**
 * Created by haze on 4/14/16.
 */
public class AndroidHandler extends Handler {

    @Override
    public void startAsync(List<Integer> program_index, List<Integer> option_index, Callback c) {
        Service service = new AndroidDLVSerice();

            List<InputProgram> input_programs = new ArrayList<InputProgram>();

        if(program_index.isEmpty()) {

            for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
                input_programs.add(this.programs.get(program.getKey()));
            }

        }else{
                for(int index : program_index){
                    input_programs.add(this.programs.get(index));

                }
            }

           List<OptionDescriptor> input_option_index = new ArrayList<OptionDescriptor>();

        if(option_index.isEmpty()){

            for (Map.Entry<Integer, OptionDescriptor> option: this.options.entrySet()) {
                input_option_index.add(this.options.get(option.getKey()));
            }

        }else{

            for(int index : option_index){
                input_option_index.add(this.options.get(index));
            }



        }

            service.startAsync(c,input_programs,input_option_index);
    }
}
