package demo.repository.country;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.domain.Person;
import java.lang.String;
import java.util.List;
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends JpaRepository<Person, Long>{
   List<Person> findByName(String name);
}
