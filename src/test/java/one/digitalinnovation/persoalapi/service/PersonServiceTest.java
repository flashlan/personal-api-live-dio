package one.digitalinnovation.persoalapi.service;

import one.digitalinnovation.persoalapi.Repository.PersonRepository;
import one.digitalinnovation.persoalapi.Service.PersonService;
import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.persoalapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.persoalapi.utils.PersonUtils.createFakeEntity;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;


    @Test
    void TestGivenPersonDTOTheReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSucessMessage = createExpectedMessageresponse(expectedSavedPerson.getId());


        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSucessMessage, sucessMessage);
    }

    private MessageResponseDTO createExpectedMessageresponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
