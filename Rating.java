public class Rating {
    private String item;
    private double value;

    public Rating(String item, double value) {
        this.item = item;
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "item='" + item + '\'' +
                ", value=" + value +
                '}';
    }

    public int compareTo(Rating other) {
        return Double.compare(value, other.value);
    }
}
