package by.liudchyk.present.creator;

import by.liudchyk.present.entity.Jujube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 08.10.2016.
 */
public class JujubeFactory {
    private static final Logger LOG = LogManager.getLogger();
    private final int WEIGHT_POS = 1;
    private final int CALORIES_POS = 2;
    private final int MANUFACTURER_POS = 3;
    private final int NAME_POS = 4;
    private final int STUFFING_POS = 5;
    private final int FRUIT_POS = 6;

    public Jujube makeJujube(String... args){
        try {
            return new Jujube(Double.valueOf(args[WEIGHT_POS]), Integer.valueOf(args[CALORIES_POS]),
                    args[MANUFACTURER_POS], args[NAME_POS], Boolean.valueOf(args[STUFFING_POS]),
                   args[FRUIT_POS]);
        }catch(IllegalArgumentException|IndexOutOfBoundsException e){
            LOG.error("Jujube args are wrong",e);
            return null;
        }
    }
}
