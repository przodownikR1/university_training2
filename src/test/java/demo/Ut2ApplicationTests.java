package demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Ut2Application.class)
@WebAppConfiguration
@DirtiesContext
@ActiveProfiles(profiles = "dev")
public class Ut2ApplicationTests {

    @Test
    @Ignore
    //TODO Błąd podczas otwierania portu "8082" (może być w użyciu), błąd: "java.net.BindException: Adres jest już w użyciu"
    public void contextLoads() {
    }

}
