package Database.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Vehicle.Vehicle;
import Vehicle.Air.Air;
import Vehicle.Air.Helicopter;
import Vehicle.Land.Land;
import Vehicle.Land.Truck;
import Vehicle.Maritime.Maritime;
import Vehicle.Maritime.Ship;

public class VehicleDatabase extends Database {
    private ArrayList<Truck> trucks;
    private ArrayList<Helicopter> helicopters;
    private ArrayList<Land> lands;
    private ArrayList<Maritime> maritimes;
    private ArrayList<Ship> ships;
    private ArrayList<Air> airs;

    public VehicleDatabase() {
        super("Arquivo.txt");

        TruckDatabase truckDatabase = new TruckDatabase();
        HelicopterDatabase helicopterDatabase = new HelicopterDatabase();
        LandDatabase landDatabase = new LandDatabase();
        MaritimeDatabase maritimeDatabase = new MaritimeDatabase();
        ShipDatabase shipDatabase = new ShipDatabase();
        AirDatabase AirDatabase = new AirDatabase();
        try {
            this.trucks = truckDatabase.getAllTruck();
            this.helicopters = helicopterDatabase.getAllHelicopter();
            this.lands = landDatabase.getAllLand();
            this.maritimes = maritimeDatabase.getAllAir();
            this.ships = shipDatabase.getAllShip();
            this.airs = AirDatabase.getAllAir();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro com o arquivo texto");
        }

    }

    public ArrayList<Vehicle> getAllVehicle() throws IOException {

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Iterator<Truck> truckIterator = this.trucks.iterator();
        while (truckIterator.hasNext()) {
            Truck dataItem = truckIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Helicopter> helicopterIterator = this.helicopters.iterator();
        while (helicopterIterator.hasNext()) {
            Helicopter dataItem = helicopterIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Land> landIterator = this.lands.iterator();
        while (landIterator.hasNext()) {
            Land dataItem = landIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Maritime> maritimeIterator = this.maritimes.iterator();
        while (maritimeIterator.hasNext()) {
            Maritime dataItem = maritimeIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Ship> shipIterator = this.ships.iterator();
        while (shipIterator.hasNext()) {
            Ship dataItem = shipIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Air> airIterator = this.airs.iterator();
        while (airIterator.hasNext()) {
            Air dataItem = airIterator.next();
            vehicles.add(dataItem);
        }

        return vehicles;
    }

    public ArrayList<Vehicle> internationalVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Iterator<Air> airIterator = this.airs.iterator();
        while (airIterator.hasNext()) {
            Air dataItem = airIterator.next();
            vehicles.add(dataItem);
        }

        Iterator<Maritime> maritimeIterator = this.maritimes.iterator();
        while (maritimeIterator.hasNext()) {
            Maritime dataItem = maritimeIterator.next();
            vehicles.add(dataItem);
        }

        Iterator<Ship> shipIterator = this.ships.iterator();
        while (shipIterator.hasNext()) {
            Ship dataItem = shipIterator.next();
            vehicles.add(dataItem);
        }

        Iterator<Helicopter> helicopterIterator = this.helicopters.iterator();
        while (helicopterIterator.hasNext()) {
            Helicopter dataItem = helicopterIterator.next();
            vehicles.add(dataItem);
        }
        return vehicles;
    }

    public ArrayList<Vehicle> intercityVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Iterator<Truck> truckIterator = this.trucks.iterator();
        while (truckIterator.hasNext()) {
            Truck dataItem = truckIterator.next();
            vehicles.add(dataItem);
        }

        Iterator<Land> landIterator = this.lands.iterator();
        while (landIterator.hasNext()) {
            Land dataItem = landIterator.next();
            vehicles.add(dataItem);
        }
        return vehicles;
    }
    public ArrayList<Vehicle> interStateVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        Iterator<Truck> truckIterator = this.trucks.iterator();
        while (truckIterator.hasNext()) {
            Truck dataItem = truckIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Helicopter> helicopterIterator = this.helicopters.iterator();
        while (helicopterIterator.hasNext()) {
            Helicopter dataItem = helicopterIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Land> landIterator = this.lands.iterator();
        while (landIterator.hasNext()) {
            Land dataItem = landIterator.next();
            vehicles.add(dataItem);
        }
        Iterator<Air> airIterator = this.airs.iterator();
        while (airIterator.hasNext()) {
            Air dataItem = airIterator.next();
            vehicles.add(dataItem);
        }
        return vehicles;
    }
    public ArrayList<String> vehicleName(ArrayList<Vehicle> vehicles) throws IOException {
        ArrayList<String> names = new ArrayList<>();
        Iterator<Vehicle> vIterator = vehicles.iterator();
        while (vIterator.hasNext()) {
            Vehicle dataItem = vIterator.next();
            names.add(dataItem.getName() + " " + dataItem.getColor());
        }
        return names;
    }

}
