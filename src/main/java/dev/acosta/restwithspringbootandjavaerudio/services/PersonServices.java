package dev.acosta.restwithspringbootandjavaerudio.services;

import dev.acosta.restwithspringbootandjavaerudio.data.vo.v1.PersonVO;
import dev.acosta.restwithspringbootandjavaerudio.exceptions.ResourceNotFoundException;
import dev.acosta.restwithspringbootandjavaerudio.model.Person;
import dev.acosta.restwithspringbootandjavaerudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public PersonVO findById(Long id) {
        logger.info("Searching a person.");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }

    public List<PersonVO> findAll() {
        logger.info("Searching all entries of person.");
        return repository.findAll();
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating new person.");
        return repository.save(person);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting a person.");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record for this ID."));
        repository.delete(entity);
    }

}
