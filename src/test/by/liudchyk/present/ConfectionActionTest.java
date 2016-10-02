package test.by.liudchyk.present;

import by.liudchyk.present.creator.PresentCreator;
import by.liudchyk.present.entity.Chocolate;
import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.entity.Jujube;
import by.liudchyk.present.entity.Sweet;
import by.liudchyk.present.exception.PercentException;
import by.liudchyk.present.logic.ConfectionAction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;

public class ConfectionActionTest {
    private static ConfectionAction confectionAction;
    private static HashSet<Confection> present = new HashSet<>();

    @Before
    public void initConfectionAction() throws FileNotFoundException {
        confectionAction = new ConfectionAction();
        PresentCreator creator = new PresentCreator();
        present = creator.makePresent("data/Data.txt");
    }

    @After
    public void clearConfectionAction(){
        confectionAction = null;
        present = null;
    }

    @Test
    public void checkFindSugarConfection1(){
        HashSet<String> actual = confectionAction.findSugarConfection(present,10,30);
        Object[] actualArray = actual.toArray();
        HashSet<String> right = new HashSet<>();
        right.add("Slodych");
        right.add("Spartak");
        Object[] expected = right.toArray();
        Assert.assertArrayEquals(expected,actualArray);
    }

    @Test
    public void checkFindSugarConfection2(){
        HashSet<String> actual = confectionAction.findSugarConfection(present,-20,0);
        Object[] actualArray = actual.toArray();
        Object[] expected = new Object[0];
        Assert.assertArrayEquals(expected,actualArray);
    }

    @Test
    public void checkTotalWeight1(){
        Double actual = confectionAction.totalWeight(present);
        Assert.assertEquals(525.0,actual,0.0001);
    }

    @Test
    public void  checkTotalWeight2() throws FileNotFoundException {
        PresentCreator pc = new PresentCreator();
        present = pc.makePresent("data/Empty.txt");
        Double actual = confectionAction.totalWeight(present);
        Assert.assertEquals(0,actual,0);
    }

    @Test
    public void checkSortPresent1() throws PercentException {
        List<Confection> sorted = confectionAction.sortPresent(present);
        Object[] actual = sorted.toArray();
        Object[] expected = new Object[5];
        expected[1] = new Jujube(75.0, 15, "Vitba", false, "orange");
        expected[0] = new Sweet(200.0, 10, "Spartak", 10.0,false);
        expected[2] = new Chocolate(100.0, 20, "Slodych", 20.0, 80);
        expected[3] = new Sweet(100.0, 22, "Komunarka", 40.0, true);
        expected[4] = new Jujube(50.0, 40, "Roshen", false, "kiwi");
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void checkSortPresent2() throws FileNotFoundException {
        PresentCreator pc = new PresentCreator();
        present = pc.makePresent("data/Empty.txt");
        List<Confection> sorted = confectionAction.sortPresent(present);
        Object[] actual = sorted.toArray();
        Object[] expected = new Object[0];
        Assert.assertArrayEquals(expected,actual);
    }

}
