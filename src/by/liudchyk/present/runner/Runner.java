package by.liudchyk.present.runner;

import by.liudchyk.present.creator.PresentCreator;
import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.logic.ConfectionAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileNotFoundException;
import java.util.HashSet;

public class Runner {
    static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {
        PresentCreator myPresent = new PresentCreator();
        ConfectionAction act = new ConfectionAction();
        try {
            HashSet<Confection> present = myPresent.makePresent("data/Data.txt");
            act.findSugarConfection(present,10,20);
            act.sortPresent(present);
            act.totalWeight(present);
        } catch (FileNotFoundException e) {
            LOG.error("Your file is not found");
        }
    }
}
