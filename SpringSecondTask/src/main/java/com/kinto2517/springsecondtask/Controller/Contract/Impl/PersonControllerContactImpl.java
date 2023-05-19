package com.kinto2517.springsecondtask.Controller.Contract.Impl;

import com.kinto2517.springsecondtask.Controller.Contract.PersonControllerContract;
import com.kinto2517.springsecondtask.Dto.PersonDTO;
import com.kinto2517.springsecondtask.Dto.PersonSaveRequest;
import com.kinto2517.springsecondtask.Entity.Person;
import com.kinto2517.springsecondtask.Mapper.PersonMapper;
import com.kinto2517.springsecondtask.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonControllerContactImpl implements PersonControllerContract {


    private final PersonService personService;

    @Override
    public PersonDTO savePerson(PersonSaveRequest personSaveRequest) {
        Person person = PersonMapper.INSTANCE.convertToPerson(personSaveRequest);
        Person savedPerson = personService.save(person);
        return PersonMapper.INSTANCE.convertToDTO(savedPerson);
    }

    @Override
    public List<PersonDTO> findAllPerson() {
        List<Person> personList = personService.findAll();
        return PersonMapper.INSTANCE.convertToDTOs(personList);
    }

    @Override
    public void deletePersonWithUsernameAndPhone(String name, String phone) {
        personService.deletePersonWithUsernameAndPhone(name, phone);
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = personService.findById(id).orElseThrow(() -> new RuntimeException("Person not found by id: " + id));
        return PersonMapper.INSTANCE.convertToDTO(person);
    }

    @Override
    public PersonDTO getPersonByName(String name) {
        Person person = personService.findByUsername(name);
        return PersonMapper.INSTANCE.convertToDTO(person);
    }

    @Override
    public PersonDTO updatePerson(PersonSaveRequest personSaveRequest, Long id) {
        Person person = PersonMapper.INSTANCE.convertToPerson(personSaveRequest);
        Person updatedPerson = personService.update(person, id);
        return PersonMapper.INSTANCE.convertToDTO(updatedPerson);
    }
}
