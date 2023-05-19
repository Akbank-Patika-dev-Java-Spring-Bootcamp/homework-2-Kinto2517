package com.kinto2517.springsecondtask.Mapper;

import com.kinto2517.springsecondtask.Entity.Person;
import com.kinto2517.springsecondtask.Dto.PersonDTO;
import com.kinto2517.springsecondtask.Dto.PersonSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    Person convertToPerson(PersonSaveRequest personSaveRequest);
    PersonDTO convertToDTO(Person person);
    List<PersonDTO> convertToDTOs(List<Person> persons);

}
