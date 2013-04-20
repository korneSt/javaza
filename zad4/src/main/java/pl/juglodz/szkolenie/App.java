
package pl.juglodz.szkolenie;

import pl.juglodz.szkolenie.logger.ConsoleLogger;
import pl.juglodz.szkolenie.logger.FileLogger;
import pl.juglodz.szkolenie.logger.PersonsLogger;
import pl.juglodz.szkolenie.logger.SimpleXmlLogger;
import pl.juglodz.szkolenie.logger.XmlLogger;
import pl.juglodz.szkolenie.person.Person;
import pl.juglodz.szkolenie.person.PersonGenerator;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/**
 * Napisz program losujacy 666 imion i nazwisk i zapisz je do pliku, a nastepnie odczytaj z pliku i
 * wypisz na ekran. Utworz dwie różne pary procedur zapisujaco/odczytujacych, raz zapisz dane do
 * pliku txt, raz do pliku xml txt format: imie;nazwisko xml format:
 * <osoba><imie>imie</imie><nazwisko>nazwisko</nazwisko>
 */
public class App {
    
    private static final String TXT_FILE = "txt";
    private static final String XML_FILE = "xml";
    private static final String XML2_FILE = "xml2";
    private ImmutableList<Person> persons; 
    public App generatePersons(){
        persons = PersonGenerator.generate(666);
        return this;
    }
    
    public static void main(String[] args) {
        App app = new App().generatePersons();//.displayPersons();
        args = new String[] {XML2_FILE};
        PersonsLogger personLoger = app.getLogger(args);
        try {
            personLoger.write();
        } catch (Exception e) {
            System.out.println("Application can't write persons" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    private PersonsLogger getLogger(String[] args) {
        PersonsLogger personLoger = new ConsoleLogger(persons);
        if (args==null || args.length < 1 || Strings.isNullOrEmpty(args[0])){
            return personLoger; 
        }
        String loggerType = args[0];
        if (TXT_FILE.equals(loggerType)){
            personLoger  = new FileLogger(persons);
        }else if (XML_FILE.equals(loggerType)){
            personLoger = new XmlLogger(persons);
        }else if (XML2_FILE.equals(loggerType)){
            personLoger = new SimpleXmlLogger(persons);
        }
        return personLoger;
    }

    private App displayPersons() {
        for (Person person : persons) {
            System.out.println(person);
        }
        // persons.remove(1);
        // persons.add(new Person("Mariusz", "Saramak")); //Because persons is immutable I can't add
        // or remove
        return this;
    }
}
