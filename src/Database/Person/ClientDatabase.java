package Database.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Person.Client;

public class ClientDatabase extends Database {

    public ClientDatabase() {
        super("Clients.txt");
    }

    public ArrayList<Client> getAllClients() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<Client> clients = new ArrayList<Client>();

        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");
            
            Client client = new Client(dataArray[0],Integer.parseInt(dataArray[1]), dataArray[2], dataArray[3], dataArray[4]);
            clients.add(client);
        }
        return clients;
    }

    public ArrayList<String> clientCPFS() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<String> cpfs = new ArrayList<>();
        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");
            
            cpfs.add(dataArray[3]);
        }
        return cpfs;
    }

    public Client getByCPF(String CPF) throws IOException {
        ArrayList<Client> clients = this.getAllClients();

        Iterator<Client> clientIterator = clients.iterator();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            if (client.getCPF().equals(CPF)) {
                return client;
            }
        }
        return null;
    }

    public boolean emailExists(String email) throws IOException {
        ArrayList<String> data = this.getAll();
        Iterator<String> dataIterator = data.iterator();
        
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");
            if (dataArray[2].equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean cpfExists(String cpf) throws IOException {
        ArrayList<String> data = this.getAll();
        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");
            if (dataArray[3].equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
