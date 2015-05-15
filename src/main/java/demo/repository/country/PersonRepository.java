package demo.repository.country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.domain.Person;

@RestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long>{
   List<Person> findByName(String name);
}
