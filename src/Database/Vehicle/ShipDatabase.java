package Database.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Vehicle.Maritime.Ship;

public class ShipDatabase extends Database {

    public ShipDatabase() {
        super("Ship.txt");
    }

    public ArrayList<Ship> getAllShip() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<Ship> ships = new ArrayList<Ship>();

        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");

            Ship Ship = new Ship(dataArray[0],
                    dataArray[1],
                    dataArray[2],
                    Double.parseDouble(dataArray[3]),
                    Double.parseDouble(dataArray[4]),
                    Double.parseDouble(dataArray[5]),
                    Double.parseDouble(dataArray[6]));
            ships.add(Ship);
        }
        return ships;
    }

}
