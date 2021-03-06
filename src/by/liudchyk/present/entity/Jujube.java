package by.liudchyk.present.entity;


public class Jujube extends Floury {
    private String fruit;

    public Jujube(double weight, int calorificValue, String manufacturer, String name, boolean stuffing, String fruit) {
        super(weight, calorificValue, manufacturer,name, stuffing);
        this.fruit = fruit;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "Jujube{" + super.toString()+
                " fruit=" + fruit  +
                '}'+";\n";
    }
}
