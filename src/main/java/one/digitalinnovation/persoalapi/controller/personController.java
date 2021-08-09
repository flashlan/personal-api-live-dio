package one.digitalinnovation.persoalapi.controller;

import one.digitalinnovation.persoalapi.Exception.PersonNotfFounfException;
import one.digitalinnovation.persoalapi.Service.PersonService;
import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);

    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotfFounfException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable Long id) throws PersonNotfFounfException {
        personService.delete(id);


    }

}
