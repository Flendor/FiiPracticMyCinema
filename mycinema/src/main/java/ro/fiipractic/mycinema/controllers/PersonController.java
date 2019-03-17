package ro.fiipractic.mycinema.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.mycinema.entities.Person;
import ro.fiipractic.mycinema.services.PersonService;

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
}
