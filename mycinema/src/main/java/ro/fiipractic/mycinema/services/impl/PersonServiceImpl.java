package ro.fiipractic.mycinema.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fiipractic.mycinema.entities.Person;
import ro.fiipractic.mycinema.repositories.PersonRepository;
import ro.fiipractic.mycinema.services.PersonService;

import java.util.List;

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
    public Person modifyName(Long id, String newName) {
        Person p = personRepository.findById(id).orElse(null);
        if (p == null)
            throw new RuntimeException("Non-existent ID!");
        p.setFullName(newName);
        return p;
    }

    @Override
    public Person modifyPhone(Long id, String newNumber) {
        Person p = personRepository.findById(id).orElse(null);
        if(p == null)
            throw new RuntimeException("Non-existent ID!");
        p.setPhone(newNumber);
        return p;
    }

    @Override
    public Person modifyEmail(Long id, String newEmail) {
        Person p = personRepository.findById(id).orElse(null);
        if (p == null)
            throw new RuntimeException("Non-existent ID!");
        p.setEmail(newEmail);
        return p;
    }

    @Override
    public Person deleteById(Long id) {
        Person p = personRepository.findById(id).orElse(null);
        if (p == null)
            throw new RuntimeException("Non-existent ID!");
        personRepository.deleteById(id);
        return p;
    }
}
