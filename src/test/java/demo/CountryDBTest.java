package demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;

import demo.config.DsConfigEmbedded;
import demo.config.PropertiesLoader;
import demo.config.RepositoryConfig;
import demo.domain.Country;
import demo.repository.country.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles="test")
@ContextConfiguration(classes = { DsConfigEmbedded.class, RepositoryConfig.class, PropertiesLoader.class })
public class CountryDBTest {

    @Autowired
    private CountryRepository repo;

    @Test
    @Ignore
    public void shouldInsertRecords() {
        // Given
        List<Country> countries = Lists.newArrayList(new Country("POLAND"), new Country("USA"), new Country("GERMANY"));

        // When
        countries.stream().forEach(c -> repo.save(c));
        // Then
        assertEquals(3, repo.count());

    }
}
