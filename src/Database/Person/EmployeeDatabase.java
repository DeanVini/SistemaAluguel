package Database.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Database.Database;
import Person.Employee;

public class EmployeeDatabase extends Database {
    public EmployeeDatabase() {
        super("Employees.txt");
    }

    public ArrayList<Employee> getAllEmployees() throws IOException {
        ArrayList<String> data = this.getAll();
        ArrayList<Employee> employees = new ArrayList<Employee>();

        Iterator<String> dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            String dataItem = dataIterator.next();
            String[] dataArray = dataItem.split("\\;");
            
            Employee employee = new Employee(dataArray[0],Integer.parseInt(dataArray[1]), dataArray[2], dataArray[3], dataArray[4]);
            employees.add(employee);
        }
        return employees;
    }

    public ArrayList<String> employeeCPFS() throws IOException {
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

    public Employee getByCPF(String CPF) throws IOException {
        ArrayList<Employee> employess = this.getAllEmployees();

        Iterator<Employee> employeeIterator = employess.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            if (employee.getCPF().equals(CPF)) {
                return employee;
            }
        }
        return null;
    }
}
