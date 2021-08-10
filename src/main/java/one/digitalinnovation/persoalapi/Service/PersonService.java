package one.digitalinnovation.persoalapi.Service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.persoalapi.Exception.PersonNotfFounfException;
import one.digitalinnovation.persoalapi.Repository.PersonRepository;
import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import one.digitalinnovation.persoalapi.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Package Service  geralmente gerencia regras de negócio da aplicação

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotfFounfException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotfFounfException(id);
        }
        return personMapper.toDTO(optionalPerson.get());
    }

    public void delete(Long id) throws PersonNotfFounfException {
        verifyIfExist(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExist(Long id) throws PersonNotfFounfException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotfFounfException(id));
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotfFounfException {
        verifyIfExist(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(savedPerson.getId(), "Updated Person with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}
