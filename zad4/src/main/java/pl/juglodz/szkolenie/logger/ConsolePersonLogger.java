
package pl.juglodz.szkolenie.logger;

import com.google.common.collect.ImmutableList;

import pl.juglodz.szkolenie.person.Person;

public class ConsolePersonLogger implements PersonsLogger {

    private final ImmutableList<Person> persons;

    public ConsolePersonLogger(ImmutableList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void write() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

   

}
