package by.liudchyk.present.logic;

import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.entity.Present;
import by.liudchyk.present.entity.Sugary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;


public class ConfectionAction {
    public ArrayList<Confection> findSugarConfection(Present present, int begin, int end){
        ArrayList<Confection> confections = new ArrayList<>();
        for(Object conf : present){
            if(conf instanceof Sugary) {
                if (((Sugary) conf).getSugar() >= begin && ((Sugary) conf).getSugar() <= end)
                    confections.add((Confection)conf);
            }
        }
        return confections;
    }

    public double totalWeight(Present present){
        double weight = 0.0;
        for(Object conf : present){
            weight+=((Confection)conf).getWeight();
        }
        return weight;
    }

   public Present sortPresent(Present present){
       List<Confection> confList = new ArrayList<>(present.getPresent());
       Collections.sort(confList, (Confection o1, Confection o2) -> o1.getCalorificValue()-o2.getCalorificValue());
       LinkedHashSet<Confection> pres = new LinkedHashSet<>(confList);
       Present present1 = new Present(pres,present.getOwner());
       return present1;
   }
}