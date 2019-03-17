package ro.fiipractic.mycinema.services;

import ro.fiipractic.mycinema.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    String helloFromService();

    Person savePerson(Person personForSave);

    Optional<Person> getById(Long id);

    List<Person> getAll();

    Person modifyPhone(Long id, String newNumber);
}
