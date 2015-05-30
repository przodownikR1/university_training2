package demo.repository.country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import demo.domain.Customer;

@RestResource(path = "people")
public interface PersonRepository extends JpaRepository<Customer, Long>{
   List<Customer> findByName(String name);
}
