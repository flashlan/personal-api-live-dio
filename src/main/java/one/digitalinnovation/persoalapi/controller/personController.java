package one.digitalinnovation.persoalapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.persoalapi.Exception.PersonNotfFounfException;
import one.digitalinnovation.persoalapi.Service.PersonService;
import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.dto.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//controller -> camada de responsabilidade rest

@RestController
@RequestMapping("/api/v1/people")
// remover construtor padrao
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class personController {

    private PersonService personService;

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

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotfFounfException {
        return personService.updateById(id, personDTO);
    }





    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable Long id) throws PersonNotfFounfException {
        personService.delete(id);


    }

}
