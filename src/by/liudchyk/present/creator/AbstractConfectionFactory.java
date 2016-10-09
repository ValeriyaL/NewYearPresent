package by.liudchyk.present.creator;

import by.liudchyk.present.entity.Confection;

/**
 * Created by Admin on 09.10.2016.
 */
public abstract class AbstractConfectionFactory {
    public abstract Confection makeConfection(String... args);
}
