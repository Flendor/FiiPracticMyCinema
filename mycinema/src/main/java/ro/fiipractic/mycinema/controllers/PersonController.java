package ro.fiipractic.mycinema.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.mycinema.entities.Person;
import ro.fiipractic.mycinema.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/hello1")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping(value = "/hello2")
    public String helloWorld2() {
        return "hello world 2";
    }

    @PostMapping(value = "/number/{number}")
    public String printMyNumber(@PathVariable("number") Integer myNumber) {
        return "My number is " + myNumber;
    }

    @PostMapping(value = "/name")
    public String printMyName(@RequestBody String myName) {
        return "My name is " + myName;
    }

    @GetMapping(value = "/helloService")
    public String helloWorldFromService() {
        return personService.helloFromService();
    }

    @PostMapping(value = "/saveMyPerson")
    public Person saveMyPerson(@RequestBody Person personForSave) {
        return personService.savePerson(personForSave);
    }

    @GetMapping(value = "/getById/{id}")
    public Person getById(@PathVariable(value = "id") Long id) {
        return personService.getById(id);
    }

    @GetMapping(value = "/getAll")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PostMapping(value = "/modifyName")
    public Person modifyName(@RequestParam(value = "id") Long id, @RequestParam(value = "newName") String newName) {
        Person p = personService.modifyName(id, newName);
        return personService.savePerson(p);
    }

    @PostMapping(value = "/modifyPhone")
    public Person modifyPhone(@RequestParam(value = "id") Long id, @RequestParam(value = "newNumber") String newNumber) {
        Person p = personService.modifyPhone(id, newNumber);
        return personService.savePerson(p);
    }

    @PostMapping(value = "/modifyEmail")
    public Person modifyEmail(@RequestParam(value = "id") Long id, @RequestParam(value = "newEmail") String newEmail) {
        Person p = personService.modifyEmail(id, newEmail);
        return personService.savePerson(p);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public Person deleteById(@PathVariable(value = "id") Long id) {
        return personService.deleteById(id);
    }
}
