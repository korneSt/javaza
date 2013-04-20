package pl.juglodz.szkolenie.reader;

import java.util.List;

import com.google.common.collect.ImmutableList;

import pl.juglodz.szkolenie.person.Person;

public interface PersonReader {

    public ImmutableList<Person> read() throws Exception;
    
}
