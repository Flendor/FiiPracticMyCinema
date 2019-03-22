package ro.fiipractic.mycinema.services;

import ro.fiipractic.mycinema.entities.Person;

import java.util.List;

public interface PersonService {
    String helloFromService();

    Person savePerson(Person personForSave);

    Person getById(Long id);

    List<Person> getAll();

    Person modifyName(Long id, String newName);

    Person modifyPhone(Long id, String newNumber);

    Person modifyEmail(Long id, String newEmail);

    Person deleteById(Long id);
}
