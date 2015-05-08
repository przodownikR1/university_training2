package demo.repository.country;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{


    Country findByName(String name);
    
}
