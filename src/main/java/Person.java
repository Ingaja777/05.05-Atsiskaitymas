import java.io.Serializable;

public class Person implements Serializable {
    private final String name;
    private final String surname;
    private final int personID;

    public Person(String name, String surname, int personID) {
        this.name = name;
        this.surname = surname;
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPersonID() {
        return personID;
    }
}
