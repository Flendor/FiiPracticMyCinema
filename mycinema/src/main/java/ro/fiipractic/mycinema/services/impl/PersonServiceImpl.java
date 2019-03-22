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
    public Person savePerson(Person personForSave) {
        return personRepository.save(personForSave);
    }

    @Override
    public Person getById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Non-existent ID!"));
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person modifyName(Long id, String newName) {
        Person p = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Non-existent ID!"));
        p.setFullName(newName);
        return personRepository.save(p);
    }

    @Override
    public Person modifyPhone(Long id, String newNumber) {
        Person p = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Non-existent ID!"));
        p.setPhone(newNumber);
        return personRepository.save(p);
    }

    @Override
    public Person modifyEmail(Long id, String newEmail) {
        Person p = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Non-existent ID!"));
        p.setEmail(newEmail);
        return personRepository.save(p);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
