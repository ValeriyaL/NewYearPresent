package by.liudchyk.present.entity;


abstract public class Sugary extends Confection {
    private double sugar;

    public Sugary() {
    }

    public Sugary(double weight, int calorificValue, String manufacturer, double sugar) {
        super(weight, calorificValue, manufacturer);
        this.sugar = sugar;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " sugar=" + sugar ;
    }
}
