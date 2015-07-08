package demo.aop.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service.xml" })
public class ServiceTest {
    @Autowired
    private Service service;

    @Test
    public void init() {
        Assert.assertTrue(true);
        Assert.assertNotNull(service);
    }

    @Test
    public void getMessage() {
        System.err.println(service.getMessage());
    }

    @Test
    public void getDouble() {
        System.err.println(service.getMessage(12d));
    }

    @Test
    public void getString() {
        System.err.println(service.getMessage("slawek"));

    }

}
