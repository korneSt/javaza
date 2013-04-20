
package pl.juglodz.szkolenie.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import pl.juglodz.szkolenie.person.Person;

import com.google.common.collect.ImmutableList;

public class FileLogger implements PersonsLogger {

    private static final String PERSONS_FILE_NAME = "target/persons.txt";
    private final ImmutableList<Person> persons;

    public FileLogger(ImmutableList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void write() throws Exception {
        File f = new File(PERSONS_FILE_NAME);
        if (!f.exists()) {
            f.createNewFile(); // throws IOException
        }
        PrintWriter pw = new PrintWriter(f);
        for (Person person : persons) {
            pw.println(person);
        }
        pw.flush();
        pw.close();
    }

}
