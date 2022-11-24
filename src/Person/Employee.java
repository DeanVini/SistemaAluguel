package Person;

/**
 * Employee
 */
public class Employee extends Person {
    private String role;

    public Employee(String name, Integer age, String email, String CPF, String role)
    {
        super(name, age, email, CPF);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return super.toString() + ";" + this.role;
    }
}