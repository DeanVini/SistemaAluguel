package Vehicle;

/**
 * Vehicle
 */
public class Vehicle {

    protected String code;
    protected String name;
    protected String color;
    protected Double height;
    protected Double width;
    protected Double velocity;

    public Vehicle(String code, String name, String color, Double height, Double width, Double velocity) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.height = height;
        this.width = width;
        this.velocity = velocity;
    }

    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public Double getVelocity() {
        return velocity;
    }
    
    public String toString() {
        return this.code + ";" + this.name + ";" + this.color + ";" + this.height + ";" + this.width + ";" + this.velocity;
    }
}