package by.liudchyk.present.report;

import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.entity.Present;

import java.util.ArrayList;

/**
 * Created by Admin on 04.10.2016.
 */
public class PresentReport {
    public void makePresentReport(Present present){
        System.out.println("\nNew Year present for "+present.getOwner());
        int length = 0;
        if (present.size() != 0) {
            length = present.toString().length()/present.size();
        }
        for(int i = 0;i<length;i++){
            System.out.print("_");
        }
        System.out.print("\n"+present);
        for(int i = 0;i<length;i++){
            System.out.print("_");
        }
    }
    public void weightReport(String owner, double weight){
        System.out.println("\nTotal weight of "+owner+"'s present: "+weight+"g");
    }
    public void sugarReport(ArrayList<Confection> confections, int start, int finish){
        System.out.println("\nConfections between "+start+" and "+finish+" sugar: ");
        for(Confection temp : confections){
            System.out.print(" - ");
            System.out.print(temp);
        }
    }
}
