package Vehicle.Maritime;

/**
 * Ship
 */
public class Ship extends Maritime{
    protected Double load;
    public Ship(String code, String name, String color, Double height, Double width, Double velocity, Double load){
        super(code, name, color, height, width, velocity);
        this.load = load;
    }

    public String toString() {
        return super.toString() + ";" + this.load;
    }
}