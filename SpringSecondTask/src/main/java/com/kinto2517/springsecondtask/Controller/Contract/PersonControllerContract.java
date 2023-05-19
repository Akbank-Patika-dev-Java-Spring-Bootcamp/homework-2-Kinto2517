package com.kinto2517.springsecondtask.Controller.Contract;

import com.kinto2517.springsecondtask.Dto.PersonDTO;
import com.kinto2517.springsecondtask.Dto.PersonSaveRequest;

import java.util.List;

public interface PersonControllerContract {
    PersonDTO savePerson(PersonSaveRequest personSaveRequest);
    List<PersonDTO> findAllPerson();
    void deletePersonWithUsernameAndPhone(String name, String phone);
    PersonDTO getPersonById(Long id);
    PersonDTO getPersonByName(String name);
    PersonDTO updatePerson(PersonSaveRequest personSaveRequest, Long id);

}
