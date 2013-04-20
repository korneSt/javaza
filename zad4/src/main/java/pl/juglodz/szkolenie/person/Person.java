
package pl.juglodz.szkolenie.person;

/**
 * Immutable object 
 * Explain what is a immutable object
 * @author saramak
 *
 */
public class Person {

    private final String name;
    private final String surname;

    // Generated constructors/ Shift+Alt+S
    public Person(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    // Generated getter and setter/ Shift+Alt+S
    public Person setName(final String newName) {
        return new Person(newName, this.surname);
    }

    public Person setSurname(final String newSurname) {
        return new Person(this.name, newSurname);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    @Override
    public String toString() {
        return name+";"+surname;
    }

}
