package com.kinto2517.springsecondtask.Service;

import com.kinto2517.springsecondtask.Base.BaseEntityService;
import com.kinto2517.springsecondtask.Dao.PersonRepository;
import com.kinto2517.springsecondtask.Entity.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseEntityService<Person, PersonRepository> {

    private final PersonRepository personRepository;
    public PersonService(PersonRepository repository) {
        super(repository);
        this.personRepository = repository;
    }

    public void deletePersonWithUsernameAndPhone(String name, String phone) {
        Person person = personRepository.findByUsernameAndPhone(name, phone);
        if (person != null) {
            personRepository.delete(person);
        }
    }
    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    public Person update(Person person, Long id) {
        Person personFromDB = findById(id).orElseThrow(() -> new RuntimeException("Person not found by id: " + id));
        personFromDB.setUsername(person.getUsername());
        personFromDB.setPhone(person.getPhone());
        return save(personFromDB);
    }
}
