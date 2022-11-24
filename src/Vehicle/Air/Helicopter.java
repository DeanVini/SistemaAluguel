package Vehicle.Air;


/**
 * Helicopter
 */
public class Helicopter extends Air{

    private Integer propellersQuantity;

    public Helicopter(String code, String name, String color, Double height, Double width, Double velocity, Integer wheelsQuantity,
            Integer propellersQuantity) {
        super(code, name, color, height, width,velocity, wheelsQuantity);
        this.propellersQuantity = propellersQuantity;
    }

    public Integer getPropellersQuantity() {
        return propellersQuantity;
    }
    
    public String toString() {
        return super.toString() + ";" + Integer.toString(this.propellersQuantity);
    }
}