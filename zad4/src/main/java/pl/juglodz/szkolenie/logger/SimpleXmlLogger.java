
package pl.juglodz.szkolenie.logger;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;

import pl.juglodz.szkolenie.logger.dto.simple.PersonsDto;
import pl.juglodz.szkolenie.person.Person;

import com.google.common.collect.ImmutableList;

public class SimpleXmlLogger implements PersonsLogger {

    private static final String TARGET_PERSONS_XML = "target/persons2.xml";
    private final ImmutableList<Person> persons;

    public SimpleXmlLogger(ImmutableList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void write() throws Exception {
        Serializer serializer = new Persister();
        PersonsDto personsDto = new PersonsDto();
        personsDto.addAll(persons);
        File result = new File(TARGET_PERSONS_XML);
        serializer.write(personsDto, result);
    }

    
}
