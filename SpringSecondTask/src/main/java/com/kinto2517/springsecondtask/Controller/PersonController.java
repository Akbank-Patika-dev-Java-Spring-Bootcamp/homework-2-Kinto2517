package com.kinto2517.springsecondtask.Controller;

import com.kinto2517.springsecondtask.Dto.PersonDTO;
import com.kinto2517.springsecondtask.Dto.PersonSaveRequest;
import com.kinto2517.springsecondtask.Error.CustomPersonError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kinto2517.springsecondtask.Controller.Contract.PersonControllerContract;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonControllerContract personControllerContract;

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        List<PersonDTO> personDTOList = personControllerContract.findAllPerson();
        return ResponseEntity.ok(personDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        PersonDTO personDTO = personControllerContract.getPersonById(id);
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping("/name")
    public ResponseEntity<PersonDTO> getPersonByName(@RequestParam("username") String username) {
        PersonDTO personDTO = personControllerContract.getPersonByName(username);
        return ResponseEntity.ok(personDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<PersonDTO> savePerson(@RequestBody PersonSaveRequest personSaveRequest) {
        PersonDTO personDTO = personControllerContract.savePerson(personSaveRequest);
        return ResponseEntity.ok(personDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<PersonDTO>> deletePersonWithUsernameAndPhone(@RequestParam("username") String username, @RequestParam("phone") String phone) {
        if (username != null && phone != null) {
            personControllerContract.deletePersonWithUsernameAndPhone(username, phone);
            return ResponseEntity.ok(new ArrayList<>());
        }else {
            String errorMessage = "Name and phone must not be null";
            CustomPersonError customPersonError = new CustomPersonError(errorMessage);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, customPersonError.toString());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonSaveRequest personSaveRequest, @PathVariable Long id) {
        PersonDTO personDTO = personControllerContract.updatePerson(personSaveRequest, id);
        return ResponseEntity.ok(personDTO);
    }

}
