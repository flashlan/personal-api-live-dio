package one.digitalinnovation.persoalapi.Service;

import one.digitalinnovation.persoalapi.Repository.PersonRepository;
import one.digitalinnovation.persoalapi.dto.MessageResponseDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

//Package Service  geralmente gerencia regras de negócio da aplicação

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }


}
