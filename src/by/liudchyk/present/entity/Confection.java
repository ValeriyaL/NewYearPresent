package by.liudchyk.present.entity;


abstract public class Confection {
    private double weight;
    private int calorificValue;
    private String manufacturer;
    private String name;

    public Confection(double weight, int calorificValue, String manufacturer, String name) {
        this.weight = weight;
        this.calorificValue = calorificValue;
        this.manufacturer = manufacturer;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  " weight=" + weight +
                " name="+ name +
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
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + calorificValue;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
