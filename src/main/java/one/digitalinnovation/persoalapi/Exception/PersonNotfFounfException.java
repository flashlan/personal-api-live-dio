package one.digitalinnovation.persoalapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotfFounfException extends Exception {
    public PersonNotfFounfException(Long id) {
        super("Person not found with id: " + id);
    }
}
