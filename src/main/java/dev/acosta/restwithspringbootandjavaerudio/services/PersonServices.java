package dev.acosta.restwithspringbootandjavaerudio.services;

import dev.acosta.restwithspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Searching a person.");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Alejandro");
        person.setLastName("Costa");
        person.setAddress("Salvador");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        logger.info("Searching all entries of person.");
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome " + i);
        person.setLastName("Sobrenome " + i);
        person.setAddress("Endereço " + i);
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating new person.");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating a person");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting a person.");
    }

}
