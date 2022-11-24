package Database.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Vehicle.Maritime.Maritime;

public class MaritimeDatabase extends Database{

    public MaritimeDatabase() {
        super("Maritime.txt");
    }

    public ArrayList<Maritime> getAllAir() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<Maritime> mars = new ArrayList<Maritime>();

        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");

            Maritime Maritime = new Maritime(dataArray[0],
                    dataArray[1],
                    dataArray[2],
                    Double.parseDouble(dataArray[3]),
                    Double.parseDouble(dataArray[4]),
                    Double.parseDouble(dataArray[5]));
            mars.add(Maritime);
        }
        return mars;
    }
}
