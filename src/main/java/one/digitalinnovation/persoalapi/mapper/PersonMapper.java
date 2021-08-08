package one.digitalinnovation.persoalapi.mapper;

import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    //constante(INSTANCE)
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

     PersonDTO toDTO(Person person);
}
