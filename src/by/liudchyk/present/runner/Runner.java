package by.liudchyk.present.runner;

import by.liudchyk.present.creator.PresentCreator;
import by.liudchyk.present.entity.Present;
import by.liudchyk.present.exception.ConfectionException;
import by.liudchyk.present.logic.ConfectionAction;
import by.liudchyk.present.report.PresentReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger LOG = LogManager.getLogger();
    private static final String PATH = "data/Data.txt";
    private static final int START_SUGAR = 10;
    private static final int END_SUGAR = 30;

    public static void main(String[] args) {
        PresentCreator myPresent = new PresentCreator();
        PresentReport report = new PresentReport();
        ConfectionAction act = new ConfectionAction();
        try {
            Present present = myPresent.makePresent(PATH);
            report.makePresentReport(present);
            report.sugarReport(act.findSugarConfection(present,START_SUGAR,END_SUGAR),START_SUGAR,END_SUGAR);
            report.weightReport(present.getOwner(),act.totalWeight(present));
        } catch (ConfectionException e){
            LOG.error(e);
        }
    }
}
