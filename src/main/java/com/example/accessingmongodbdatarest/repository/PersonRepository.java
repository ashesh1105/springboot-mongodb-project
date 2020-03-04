package com.example.accessingmongodbdatarest.repository;

import com.example.accessingmongodbdatarest.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends MongoRepository<Person, String> {

    // Spring Boot will generate all the CRUD operations by default but we can add more, as below
    Person findByLastName(@Param("firstName") String lastName);

    Person findByFirstName(@Param("lastName") String firstName);

}
