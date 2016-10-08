package test.by.liudchyk.present.creator;

import by.liudchyk.present.creator.PresentCreator;
import by.liudchyk.present.entity.Present;
import by.liudchyk.present.exception.ConfectionException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Admin on 08.10.2016.
 */
public class PresentCreatorTest {
    private PresentCreator creator;
    private Present present;

    @Before
    public void initPresentCreator() {
        creator = new PresentCreator();
    }

    @After
    public void clearPresentCreator(){
        creator = null;
    }

    @Test(expected = ConfectionException.class)
    public void checkMakePresent1() throws ConfectionException{
        creator.makePresent("data/WrongConfection.txt");
    }

    @Test(expected = RuntimeException.class)
    public void checkMakePresent2() throws ConfectionException{
        creator.makePresent("NoFile.txt");
    }

    @Test
    public void checkMakePresent3() throws ConfectionException{
        present = creator.makePresent("data/Empty.txt");
        Assert.assertEquals(0,present.size());
    }

    @Test
    public void checkMakePresent4() throws ConfectionException{
        present = creator.makePresent("data/Data.txt");
        Assert.assertEquals(8,present.size());
    }

    @Test
    public void checkMakePresent5() throws ConfectionException{
        present = creator.makePresent("data/WithMistakes.txt");
        Assert.assertEquals(5,present.size());
    }
}
