package dev.acosta.restwithspringbootandjavaerudio.services;

import dev.acosta.restwithspringbootandjavaerudio.data.vo.v1.PersonVO;
import dev.acosta.restwithspringbootandjavaerudio.data.vo.v2.PersonVOV2;
import dev.acosta.restwithspringbootandjavaerudio.exceptions.ResourceNotFoundException;
import dev.acosta.restwithspringbootandjavaerudio.mapper.DozerMapper;
import dev.acosta.restwithspringbootandjavaerudio.model.Person;
import dev.acosta.restwithspringbootandjavaerudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public PersonVO findById(Long id) {
        logger.info("Searching a person.");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Searching all entries of person.");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating new person.");
        Person newPerson = repository.save(DozerMapper.parseObject(person, Person.class));
        return DozerMapper.parseObject(newPerson, PersonVO.class);
    }

    public PersonVOV2 create(PersonVOV2 person) {
        logger.info("Creating new person in v.2");
        Person newPerson = repository.save(DozerMapper.parseObject(person, Person.class));
        return DozerMapper.parseObject(newPerson, PersonVOV2.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        Person updatedPerson = repository.save(entity);
        return DozerMapper.parseObject(updatedPerson, PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting a person.");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record for this ID."));
        repository.delete(entity);
    }

}
