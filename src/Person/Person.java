package Person;

/**
 * Person
 */
public class Person {
    private String name;
    private Integer age;
    private String email;
    private String CPF;

    /**
     * 
     * @param name
     * @param age
     * @param email
     * @param license
     * @param CPF
     */
    public Person(String name, Integer age, String email, String CPF)
    {
        this.name = name;
        this.age = age;
        this.email = email;
        this.CPF = CPF;
    }

    public String getName() {
        return this.name;
    }
    
    public Integer getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String toString() {
        return this.name + ";" + this.age + ";" + this.email + ";" + this.CPF;
    }
}