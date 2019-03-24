package ro.fiipractic.mycinema.services;

import ro.fiipractic.mycinema.entities.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person personForSave);

    Person getById(Long id);

    List<Person> getAll();

    Person modifyName(Long id, String newName);

    Person modifyPhone(Long id, String newNumber);

    Person modifyEmail(Long id, String newEmail);

    Person update(Long id, String newName, String newEmail, String newPhone);

    void deleteById(Long id);
}
