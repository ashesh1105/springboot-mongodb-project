package com.example.accessingmongodbdatarest.service;

import com.example.accessingmongodbdatarest.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

//@Path("/personservice")
//@Produces("application/json")
//@Consumes("application/json")
@Service
public interface PersonService {

    // Create operation
    Person create(Person person);

    // Bulk create operation
    List<Person> bulkUpload(List<Person> people);

    // Retrieve operations

    List<Person> getAll();

    Person getByFirstName(String firstName);

    Person getByLastName(String lastName);

    // Update operation
    Person update(String firstName, String lastName);

    // Delete operation
    void deleteAll();

    Person delete(String firstName);

}
