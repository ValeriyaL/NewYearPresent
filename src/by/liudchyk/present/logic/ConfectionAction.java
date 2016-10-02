package by.liudchyk.present.logic;

import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.entity.Sugary;

import java.util.*;

public class ConfectionAction {
    public  HashSet<String> findSugarConfection(HashSet<Confection> present, int begin, int end){
        HashSet<String> manufacturers = new HashSet<>();
        for(Confection conf : present){
            if(conf instanceof Sugary) {
                if (((Sugary) conf).getSugar() >= begin && ((Sugary) conf).getSugar() <= end)
                    manufacturers.add(conf.getManufacturer());
            }
        }
        return manufacturers;
    }

    public double totalWeight(HashSet<Confection> present){
        double weight = 0.0;
        for(Confection conf : present){
            weight+=conf.getWeight();
        }
        return weight;
    }

   public List<Confection> sortPresent(HashSet<Confection> present){
       List<Confection> confList = new ArrayList<>(present);
       Collections.sort(confList, (Confection o1, Confection o2) -> o1.getCalorificValue()-o2.getCalorificValue());
       return confList;
   }
}