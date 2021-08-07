package one.digitalinnovation.persoalapi.Repository;

import one.digitalinnovation.persoalapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//passar por generics a entidade a gerenciare e o tipo de dados do id
// substitui o antigo entitymanager
public interface PersonRepository extends JpaRepository<Person, Long> {

}
