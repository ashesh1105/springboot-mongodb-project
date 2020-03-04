package com.example.accessingmongodbdatarest.controller;

import com.example.accessingmongodbdatarest.model.Person;
import com.example.accessingmongodbdatarest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/")
@Consumes("application/json")
@Produces("application/json")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hey Ashesh!";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {

        return personService.create(person);
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public List<Person> bulkUploadPeople(@RequestBody List<Person> people) {

        return personService.bulkUpload(people);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Person getPerson(@RequestParam String firstName) {

        return personService.getByFirstName(firstName);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Person> getAllPerson() {

        return personService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public Person update(@RequestBody Person person) {

        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        return personService.update(firstName, lastName);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Person delete(@RequestParam String firstName) {

        return personService.delete(firstName);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public String deleteAll(@RequestParam String firstName) {

        personService.deleteAll();

        return "Deleted all records!";
    }

}
