package Database;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Database
 */
public class Database {

    protected String file;
    protected PrintWriter printter;
    protected FileWriter fileWriter;
    protected BufferedReader bufferedReader;
    protected FileReader fileReader;

    public Database(String table) {
        this.file = table;
        try {
            this.fileReader = new FileReader(this.file);
            this.bufferedReader = new BufferedReader(fileReader);
            this.fileWriter = new FileWriter(this.file, true);
            this.printter = new PrintWriter(this.fileWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(String line) throws IOException{
        this.printter.append(line);
        this.printter.println("");
        this.printter.close();
    }

    public ArrayList<String> getAll() throws IOException {

        ArrayList<String> data = new ArrayList<String>();

        String line = this.bufferedReader.readLine();

        while (line != null) {// ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            data.add(line.trim());// ADICIONANDO O ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            line = this.bufferedReader.readLine();// LENDO OUTRA LINHA
        }

        this.bufferedReader.close();
        return data;
    }

}