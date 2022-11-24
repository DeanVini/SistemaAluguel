package Database.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Vehicle.Land.Land;

public class LandDatabase extends Database{

    public LandDatabase() {
        super("Land.txt");
    }

    public ArrayList<Land> getAllLand() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<Land> lands = new ArrayList<Land>();

        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");

            Land Land = new Land(dataArray[0],
                    dataArray[1],
                    dataArray[2],
                    Double.parseDouble(dataArray[3]),
                    Double.parseDouble(dataArray[4]),
                    Double.parseDouble(dataArray[5])
                    );
            lands.add(Land);
        }
        return lands;
    }
    
}
