package by.liudchyk.present.creator;


import by.liudchyk.present.entity.*;
import by.liudchyk.present.exception.PercentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class PresentCreator {
    final Logger LOG = LogManager.getLogger();

    public HashSet<Confection> makePresent(String fileName) throws FileNotFoundException {
        HashSet<Confection> present = new HashSet<>();
        try {
            Scanner in = new Scanner(new File(fileName));
            while (in.hasNext()) {
                String conf = in.next();
                switch (conf) {
                    case "Sweet":
                        Sweet sweet = new Sweet(in.nextDouble(), in.nextInt(), in.next(), in.nextDouble(), in.nextBoolean());
                        present.add(sweet);
                        break;
                    case "Jujube":
                        Jujube jujube = new Jujube(in.nextDouble(), in.nextInt(), in.next(), in.nextBoolean(), in.next());
                        present.add(jujube);
                        break;
                    case "Chocolate":
                        try {
                            Chocolate choco = new Chocolate(in.nextDouble(), in.nextInt(), in.next(), in.nextDouble(), in.nextInt());
                            present.add(choco);
                        } catch (PercentException e) {
                            LOG.error("Precents of chocolate must be between 0 and 100");
                        }
                        break;
                    default:
                        LOG.error("Incorrect data in your file");
                }
            }
        }catch (NoSuchElementException e){
            LOG.error("Incorrect data in your file");
        }
        return present;
    }
}
