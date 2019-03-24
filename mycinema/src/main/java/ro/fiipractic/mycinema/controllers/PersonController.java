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

    @PostMapping
    public Person savePerson(@RequestBody Person personToSave) {
        return personService.savePerson(personToSave);
    }

    @GetMapping(value = "/{id}")
    public Person getById(@PathVariable(value = "id") Long id) {
        return personService.getById(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PatchMapping(value = "/name")
    public Person modifyName(@RequestParam(value = "id") Long id, @RequestParam(value = "newName") String newName) {
        return personService.modifyName(id, newName);
    }

    @PatchMapping(value = "/phone")
    public Person modifyPhone(@RequestParam(value = "id") Long id, @RequestParam(value = "newNumber") String newNumber) {
        return personService.modifyPhone(id, newNumber);
    }

    @PatchMapping(value = "/email")
    public Person modifyEmail(@RequestParam(value = "id") Long id, @RequestParam(value = "newEmail") String newEmail) {
        return personService.modifyEmail(id, newEmail);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        personService.deleteById(id);
    }

    @PutMapping(value = "/all")
    public Person updatePerson(@RequestParam(value = "id") Long id, @RequestParam(value = "newName") String newName,
                               @RequestParam(value = "newPhone") String newPhone, @RequestParam(value = "newEmail") String newEmail) {
        return personService.update(id, newName, newPhone, newEmail);
    }
}
