package ro.fiipractic.mycinema.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fiipractic.mycinema.entities.Person;
import ro.fiipractic.mycinema.repositories.PersonRepository;
import ro.fiipractic.mycinema.services.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public String helloFromService() {
        return "Hello from service!";
    }

    @Override
    public Person savePerson(Person personForSave) {
        return personRepository.save(personForSave);
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person modifyPhone(Long id, String newNumber) {
        Person p = personRepository.findById(id).orElse(null);
        p.setPhone(newNumber);
        return p;
    }
}
