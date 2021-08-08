package one.digitalinnovation.persoalapi.Service;

import one.digitalinnovation.persoalapi.Repository.PersonRepository;
import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import one.digitalinnovation.persoalapi.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

//Package Service  geralmente gerencia regras de negócio da aplicação

@Service
public class PersonService {

    private PersonRepository personRepository;


    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }


}
