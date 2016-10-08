package by.liudchyk.present.entity;


public class Sweet extends Sugary {
    private boolean chocolate;

    public Sweet(double weight, int calorificValue, String manufacturer, String name, double sugar, boolean chocolate) {
        super(weight, calorificValue, manufacturer, name, sugar);
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
                '}'+";\n";
    }
}
