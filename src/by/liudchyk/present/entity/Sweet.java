package by.liudchyk.present.entity;


public class Sweet extends Sugary {
    private boolean chocolate;

    public Sweet() {}

    public Sweet(double weight, int calorificValue, String manufacturer, double sugar, boolean chocolate) {
        super(weight, calorificValue, manufacturer, sugar);
        this.chocolate = chocolate;
    }

    public boolean isChocolate() {
        return chocolate;
    }

    public void setChocolate(boolean chocolate) {
        this.chocolate = chocolate;
    }

    @Override
    public String toString() {
        return "Sweet{" + super.toString() +
                " chocolate=" + chocolate +
                '}';
    }
}
