package by.liudchyk.present.entity;


abstract public class Floury extends Confection{
    private boolean stuffing;

    public Floury(double weight, int calorificValue, String manufacturer, String name, boolean stuffing) {
        super(weight, calorificValue, manufacturer,name);
        this.stuffing = stuffing;
    }

    public boolean isStuffing() {
        return stuffing;
    }

    public void setStuffing(boolean stuffing) {
        this.stuffing = stuffing;
    }

    @Override
    public String toString() {
        return super.toString() +
                " stuffing=" + stuffing;
    }
}