package com.example.accessingmongodbdatarest.service;

import com.example.accessingmongodbdatarest.model.Person;
import com.example.accessingmongodbdatarest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@Service
@Produces("application/json")
@Consumes("application/json")
public class ProductServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    // Create operation
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> bulkUpload(List<Person> people) {
        return personRepository.saveAll(people);
    }

    // Retrieve operations
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    public Person getByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    // Update operations
    public Person update(String firstName, String lastName) {
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        return personRepository.save(p);
    }

    // Delete operation
    public void deleteAll() {
        personRepository.deleteAll();
    }

    public Person delete(String firstName) {

        Person person = personRepository.findByFirstName(firstName);
        personRepository.delete(person);

        return person;
    }

}
