package by.liudchyk.present.entity;


abstract public class Floury extends Confection{
    private boolean stuffing;

    public Floury() {}

    public Floury(double weight, int calorificValue, String manufacturer, boolean stuffing) {
        super(weight, calorificValue, manufacturer);
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