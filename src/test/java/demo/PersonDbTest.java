package demo;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.config.DsConfigEmbedded;
import demo.config.PropertiesLoader;
import demo.config.RepositoryConfig;
import demo.domain.Address;
import demo.domain.Customer;
import demo.domain.Sex;
import demo.repository.country.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles="test")
@ContextConfiguration(classes = { DsConfigEmbedded.class, RepositoryConfig.class, PropertiesLoader.class })
public class PersonDbTest {
    @Autowired
    private PersonRepository personRepository;
    
    @Test
    public void shouldPersonRepoWork() {
        //given
        Customer p = Customer.builder().age(12).name("przodownik").salary(new BigDecimal("34")).sex(Sex.Male).address(new Address("Warsaw", "polna", "Poland", "04-082")).build();
        //when
        personRepository.save(p);
        //then
        assertThat(personRepository.findByName("przodownik")).hasSize(1);
        assertThat(personRepository.findByName("przodownik").get(0).getAddress()).isEqualTo(p.getAddress());
    }
}
