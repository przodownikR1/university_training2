package demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.domain.Address;
import demo.domain.Person;
import demo.domain.Sex;
import demo.repository.country.PersonRepository;

@SpringBootApplication
public class Ut2Application {
    // tag:main[]
    @Bean
    InitializingBean populateData(final PersonRepository personRepository) {
        return () -> {
            personRepository.save(Person.builder().age(36).name("przodownik").salary(new BigDecimal("3334")).sex(Sex.Male)
                    .address(new Address("Warsaw", "polna", "Poland", "04-082")).build());
            personRepository.save(Person.builder().age(34).name("kowalski").salary(new BigDecimal("754")).sex(Sex.Male)
                    .address(new Address("Radom", "25 czerwca", "Poland", "27-100")).build());
            personRepository.save(Person.builder().age(4).name("kalina").salary(new BigDecimal("99")).sex(Sex.Female)
                    .address(new Address("Warsaw", "krypska", "Poland", "04-082")).build());
        };

    }
    // end:main[]

    public static void main(String[] args) {
        SpringApplication.run(Ut2Application.class, args);

    }
}
