package one.digitalinnovation.persoalapi.controller;

import one.digitalinnovation.persoalapi.Service.PersonService;
import one.digitalinnovation.persoalapi.dto.MessageResponseDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//controller -> camada de responsabilidade rest

@RestController
@RequestMapping("/api/v1/people")
public class personController {

    private PersonService personService;

    @Autowired
    public personController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //objeto pessoa é passado durante a requisicao em formato json
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);

    }


}
