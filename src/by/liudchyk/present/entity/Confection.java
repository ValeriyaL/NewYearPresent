package by.liudchyk.present.entity;


abstract public class Confection {
    private double weight;
    private int calorificValue;
    private String manufacturer;

    public Confection() {}

    public Confection(double weight, int calorificValue, String manufacturer) {
        this.weight = weight;
        this.calorificValue = calorificValue;
        this.manufacturer = manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public int getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(int calorificValue) {
        this.calorificValue = calorificValue;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return  " weight=" + weight +
                " calorificValue=" + calorificValue +
                " manufacturer=" + manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Confection that = (Confection) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        if (calorificValue != that.calorificValue) return false;
        return manufacturer != null ? manufacturer.equals(that.manufacturer) : that.manufacturer == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + calorificValue;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }
}
