package by.liudchyk.present.entity;

import by.liudchyk.present.exception.PercentException;


public class Chocolate extends Sugary {
    private final int MIN_PERCENT = 0;
    private final int MAX_PERCENT = 100;
    private int percent;

    public Chocolate(double weight, int calorificValue, String manufacturer, String name, double sugar, int percent) throws PercentException {
        super(weight, calorificValue, manufacturer,name, sugar);
        if(percent>=MIN_PERCENT && percent<=MAX_PERCENT) {
            this.percent = percent;
        } else {
            throw new PercentException();
        }
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) throws PercentException {
        if(percent>=MIN_PERCENT && percent<=MAX_PERCENT) {
            this.percent = percent;
        } else {
            throw new PercentException();
        }
    }

    @Override
    public String toString() {
        return "Chocolate{" +super.toString()+
                " percent=" + percent +
                " }"+";\n" ;
    }
}
