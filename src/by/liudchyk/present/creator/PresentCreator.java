package by.liudchyk.present.creator;



import by.liudchyk.present.entity.*;
import by.liudchyk.present.exception.ConfectionException;
import by.liudchyk.present.exception.PercentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PresentCreator {
    private static final Logger LOG = LogManager.getLogger();
    private final String ARG_PATTERN = "\\s+";
    private final int CONFECTION_POS = 0;

    public Present makePresent(String fileName) throws ConfectionException {
        HashSet<Confection> present = new HashSet<>();
        String owner="";
        Scanner in;
        try {
            in = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            LOG.fatal("File not found",e);
            throw new RuntimeException("No file", e);
        }
        if(in.hasNextLine()) {
            owner = in.nextLine();
        }
        while (in.hasNextLine()) {
            String[] arguments =  in.nextLine().trim().split(ARG_PATTERN);
            String conf = arguments[CONFECTION_POS];
            Confection addingConfection;
            switch (conf) {
                case "Sweet":
                    addingConfection = new SweetFactory().makeSweet(arguments);
                    break;
                case "Jujube":
                    addingConfection = new JujubeFactory().makeJujube(arguments);
                    break;
                case "Chocolate":
                    addingConfection = new ChocolateFactory().makeChocolate(arguments);
                    break;
                default:
                    throw new ConfectionException("Wrong data in your file");
            }
            if(addingConfection!=null){
                present.add(addingConfection);
            }
        }
        return new Present(present, owner);
    }
}
