package pl.juglodz.szkolenie.reader;

import java.io.File;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import pl.juglodz.szkolenie.logger.dto.simple.PersonDto;
import pl.juglodz.szkolenie.logger.dto.simple.PersonsDto;
import pl.juglodz.szkolenie.person.Person;

public class SimpleXmlPersonReader implements PersonReader {

    private static final String SOURCE_PERSONS_XML = "target/persons2.xml";
    @Override
    public ImmutableList<Person> read() throws Exception {
        Serializer serializer = new Persister();
        File source = new File(SOURCE_PERSONS_XML);

        PersonsDto personsDto = serializer.read(PersonsDto.class, source);
        List<PersonDto> personDtoList = personsDto.getList();
        Builder<Person> personsListBuilder = ImmutableList.builder();
        for (PersonDto personDto : personDtoList) {
            personsListBuilder.add(new Person(personDto.getName(), personDto.getSurname()));
        }
        return personsListBuilder.build();
    }

}
