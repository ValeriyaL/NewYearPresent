package test.by.liudchyk.present.logic;

import by.liudchyk.present.creator.PresentCreator;
import by.liudchyk.present.entity.Chocolate;
import by.liudchyk.present.entity.Confection;
import by.liudchyk.present.entity.Present;
import by.liudchyk.present.entity.Sweet;
import by.liudchyk.present.exception.ConfectionException;
import by.liudchyk.present.exception.PercentException;
import by.liudchyk.present.logic.ConfectionAction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ConfectionActionTest {
    private static ConfectionAction confectionAction;
    private static Present present;

    @Before
    public void initConfectionAction() throws ConfectionException {
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
    public void checkFindSugarConfection1() throws PercentException{
        ArrayList<Confection> actual= confectionAction.findSugarConfection(present,10,30);
        Object[] actualArray = actual.toArray();
        ArrayList<Confection> right = new ArrayList<>();
        right.add(new Chocolate(100.0,20,"Slodych","Gorky",10.0,80));
        right.add(new Chocolate(100.0,30,"Slodych","Cow",20.0,80));
        right.add(new Sweet(200.0,10,"Spartak","Vityaz",10.0,false));
        Object[] expected = right.toArray();
        Assert.assertArrayEquals(expected,actualArray);
    }

    @Test
    public void checkFindSugarConfection2(){
        ArrayList<Confection> actual = confectionAction.findSugarConfection(present,-20,0);
        Object[] actualArray = actual.toArray();
        Object[] expected = new Object[0];
        Assert.assertArrayEquals(expected,actualArray);
    }

    @Test
    public void checkTotalWeight1(){
        Double actual = confectionAction.totalWeight(present);
        Assert.assertEquals(801.0,actual,0.0001);
    }

    @Test
    public void  checkTotalWeight2() throws ConfectionException {
        PresentCreator pc = new PresentCreator();
        present = pc.makePresent("data/Empty.txt");
        Double actual = confectionAction.totalWeight(present);
        Assert.assertEquals(0,actual,0);
    }

}
