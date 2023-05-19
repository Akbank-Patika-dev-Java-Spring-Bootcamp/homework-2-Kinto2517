package com.kinto2517.springsecondtask.Mapper;

import com.kinto2517.springsecondtask.Dto.PersonDTO;
import com.kinto2517.springsecondtask.Dto.PersonSaveRequest;
import com.kinto2517.springsecondtask.Entity.Person;
import com.kinto2517.springsecondtask.Enums.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T11:46:26+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person convertToPerson(PersonSaveRequest personSaveRequest) {
        if ( personSaveRequest == null ) {
            return null;
        }

        Person person = new Person();

        person.setUsername( personSaveRequest.username() );
        person.setMail( personSaveRequest.mail() );
        person.setPhone( personSaveRequest.phone() );
        if ( personSaveRequest.userType() != null ) {
            person.setUserType( Enum.valueOf( UserType.class, personSaveRequest.userType() ) );
        }

        return person;
    }

    @Override
    public PersonDTO convertToDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String mail = null;
        String phone = null;
        String userType = null;

        id = person.getId();
        username = person.getUsername();
        mail = person.getMail();
        phone = person.getPhone();
        if ( person.getUserType() != null ) {
            userType = person.getUserType().name();
        }

        PersonDTO personDTO = new PersonDTO( id, username, mail, phone, userType );

        return personDTO;
    }

    @Override
    public List<PersonDTO> convertToDTOs(List<Person> persons) {
        if ( persons == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( persons.size() );
        for ( Person person : persons ) {
            list.add( convertToDTO( person ) );
        }

        return list;
    }
}
