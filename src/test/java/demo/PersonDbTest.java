package demo;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.config.DsConfigEmbedded;
import demo.config.EhCacheConfig;
import demo.config.PropertiesLoader;
import demo.config.RepositoryConfig;
import demo.domain.Address;
import demo.domain.Person;
import demo.domain.Sex;
import demo.repository.country.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@Slf4j
@ContextConfiguration(classes = { DsConfigEmbedded.class, RepositoryConfig.class, PropertiesLoader.class, EhCacheConfig.class })
public class PersonDbTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldPersonRepoWork() {
        // given
        Person p = Person.builder().age(12).name("przodownik").salary(new BigDecimal("34")).sex(Sex.Male)
                .address(new Address("Warsaw", "polna", "Poland", "04-082")).build();
        // when
        personRepository.save(p);
        // then
        for (int i = 0; i < 5; i++) {
            assertThat(personRepository.findByName("przodownik")).hasSize(1);
            assertThat(personRepository.findByName("przodownik").get(0).getAddress()).isEqualTo(p.getAddress());
            // System.in.read();
        }
    }

    @Test
    public void shouldOptionalDaoWork() {
        // given
        Person p = Person.builder().age(12).name("przodownik").salary(new BigDecimal("34")).sex(Sex.Male)
                .address(new Address("Warsaw", "polna", "Poland", "04-082")).build();
        // when
        personRepository.save(p);

        Optional<Person> result = personRepository.findByAge(12);
        Person person = result.get();
        System.err.println(person);

        // list.stream().forEach(t -> log.info("{}", t));

    }
}
