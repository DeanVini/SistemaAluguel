package Database.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Vehicle.Air.Air;

public class AirDatabase extends Database{

    public AirDatabase() {
        super("Air.txt");
    }

    public ArrayList<Air> getAllAir() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<Air> airs = new ArrayList<Air>();

        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");

            Air Air = new Air(dataArray[0],
                    dataArray[1],
                    dataArray[2],
                    Double.parseDouble(dataArray[3]),
                    Double.parseDouble(dataArray[4]),
                    Double.parseDouble(dataArray[5]),
                    Integer.parseInt(dataArray[6])
                    );
            airs.add(Air);
        }
        return airs;
    }
}
