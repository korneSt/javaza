
package pl.juglodz.szkolenie.logger.dto.simple;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import pl.juglodz.szkolenie.person.Person;

@Root(name="persons")
public class PersonsDto {

    @ElementList(inline=true)
    private List<PersonDto> list;

    public PersonsDto() {
        list = new ArrayList<PersonDto>();
    }

    public void addAll(List<Person> persons) {
        for (Person person : persons) {
            list.add(PersonDto.valueOf(person));
        }
    }

}
