
package pl.juglodz.szkolenie.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;

public class PersonGenerator {

    private static final ImmutableList<String> NAMES = ImmutableList.of("Mariusz", "Grzegorz", "Agnieszka", "Sara", "Marta", "Antonina");
    private static final ImmutableList<String> SURNAMES = ImmutableList.of("Saramak", "Wodo", "Janecka", "Franc");
    private static final Random NAMES_NBR_GENERATOR = new Random();
    private static final Random SURNAMES_NBR_GENERATOR = new Random();
    private static final int NAMES_SIZE;
    private static final int SURNAME_SIZE;
    static {
        NAMES_SIZE = NAMES.size();
        SURNAME_SIZE = SURNAMES.size();
    }

    public static ImmutableList<Person> generate(int generateSize) {
        List<Person> person = new ArrayList<Person>();
        for (int i = 0; i < generateSize; i++) {
            person.add(new Person(getRandomName(), getRandomSurname()));
        }
        return ImmutableList.copyOf(person);
    }

    private static String getRandomSurname() {
        return SURNAMES.get(SURNAMES_NBR_GENERATOR.nextInt(SURNAME_SIZE));
    }

    private static String getRandomName() {
        return NAMES.get(NAMES_NBR_GENERATOR.nextInt(NAMES_SIZE));
    }

}
