package one.digitalinnovation.persoalapi.utils;

import one.digitalinnovation.persoalapi.dto.request.PersonDTO;
import one.digitalinnovation.persoalapi.entity.Person;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Everton";
    private static  final String LAST_NAME = "Kozloski";
    private static final String CPF_NUMBER = "033.913.009-14";
    private static final Long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1980, 04, 25 );

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("25-04-1980")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
