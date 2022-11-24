package Rent;

import Person.Client;
import Person.Employee;
import Vehicle.Vehicle;
/**
 * Rent
 */
public class Rent {

    private String vehicle;
    private String client;
    private String employee;
    private String paymentMethod;
    private Double value;

    public Rent(String vehicle, String client, String employee, String paymentMethod, Double value)
    {
        this.vehicle = vehicle;
        this.client = client;
        this.employee = employee;
        this.paymentMethod = paymentMethod;
        this.value = value;
    }

    public String toString() {
        return this.vehicle + ";" + this.client + ";" + this.employee + ";" + this.paymentMethod + ";" + this.value;
    }
    
}