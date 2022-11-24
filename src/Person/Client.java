package Person;

/**
 * Client
 */
public class Client extends Person {

    private String license;

    public Client(String name, Integer age, String email, String CPF, String license)
    {
        super(name, age, email, CPF);
        this.license = license;
    }

    public Boolean isAllowed() 
    {
        return getAge() > 18;    
    }

    public String getLicense() {
        return this.license;
    }

    public String toString() {
        return super.toString() + ";" + this.license;
    }

    public Integer indexLicenseComboBox() {
        if (this.license.equals("B")) {
            return 1;
        }
        if (this.license.equals("C")) {
            return 2;
        }
        if (this.license.equals("D")) {
            return 3;
        }
        if (this.license.equals("E")) {
            return 4;
        }
        
        return 0;
    }
}