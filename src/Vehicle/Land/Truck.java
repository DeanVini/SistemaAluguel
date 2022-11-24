package Vehicle.Land;

/**
 * Motocycle
 */
public class Truck extends Land{
    protected Double load;
    public Truck(String code, String name, String color, Double height, Double width, Double velocity, Double load){
        super(code, name, color, height, width, velocity);
        this.load = load;
    }

    public String toString() {
        return super.toString() + ";" + this.load;
    }
}