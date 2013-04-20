
package pl.juglodz.szkolenie.logger;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import pl.juglodz.szkolenie.person.Person;

import com.google.common.collect.ImmutableList;

public class XmlLogger implements PersonsLogger {

    private static final String TARGET_PERSONS_XML = "target/persons.xml";
    private static final String XML_TAG_PERSONS = "persons";
    private static final String XML_TAG_PERSON = "person";
    private static final String XML_TAG_NAME = "name";
    private static final String XML_TAG_SURNAME = "surname";
    private final ImmutableList<Person> persons;
    private Document doc;

    public XmlLogger(ImmutableList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void write() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // root element, persons
        doc = docBuilder.newDocument();
        Element rootElement = doc.createElement(XML_TAG_PERSONS);
        doc.appendChild(rootElement);
        for (Person person : persons) {
            addPersonElement(rootElement, person);
        }
        writeResultToXml();
    }

    private void writeResultToXml() throws TransformerException {
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(TARGET_PERSONS_XML));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }

    private void addPersonElement(Element parentElement, Person person) {
        // person elements
        Element personElement = doc.createElement(XML_TAG_PERSON);
        parentElement.appendChild(personElement);
        addFirstName(personElement, person);
        addSurname(personElement, person);
    }

    /**
     * Add firstname element to person element
     * 
     * @param personElement
     * @param person
     */
    private void addFirstName(Element personElement, Person person) {
        Element firstname = doc.createElement(XML_TAG_NAME);
        firstname.appendChild(doc.createTextNode(person.getName()));
        personElement.appendChild(firstname);
    }

    /**
     * Add surname element to person element
     * 
     * @param personElement
     * @param person
     */
    private void addSurname(Element personElement, Person person) {
        Element surname = doc.createElement(XML_TAG_SURNAME);
        surname.appendChild(doc.createTextNode(person.getSurname()));
        personElement.appendChild(surname);
    }

}
