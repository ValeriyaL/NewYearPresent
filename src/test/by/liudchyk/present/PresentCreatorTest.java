package test.by.liudchyk.present;

import by.liudchyk.present.creator.PresentCreator;
import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.entity.Sweet;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class PresentCreatorTest {
    private static PresentCreator creator;

    @BeforeClass
    public static void initConfectionAction() throws FileNotFoundException {
        creator = new PresentCreator();
    }

    @AfterClass
    public static void clearConfectionAction(){
        creator = null;
    }

    @Test(expected = FileNotFoundException.class)
    public void checkMakePresent1() throws FileNotFoundException {
        creator.makePresent("Nofile.txt");
    }

    @Test
    public void checkMakePresent2() throws FileNotFoundException {
        HashSet<Confection> present = creator.makePresent("data/Empty.txt");
        Object[] actual = present.toArray();
        Object[] expected = new Object[0];
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void checkMakePresent3() throws FileNotFoundException {
        HashSet<Confection> present = creator.makePresent("data/WrongFile.txt");
        Object[] actual = present.toArray();
        Object[] expected = {new Sweet(200.0, 10, "Spartak", 10.0,false)};
        Assert.assertArrayEquals(expected,actual);
    }
}
