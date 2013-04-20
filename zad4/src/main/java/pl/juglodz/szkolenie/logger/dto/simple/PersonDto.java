
package pl.juglodz.szkolenie.logger.dto.simple;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import pl.juglodz.szkolenie.person.Person;
@Root(name="person")
public class PersonDto {

    @Element
    private String name;
    
    @Element
    private String surname;
    

    private PersonDto(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
    }

    public static PersonDto valueOf(Person person) {
        return new PersonDto(person);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    
}
