package demo.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.aop.service.CarMechanicService;
import demo.aop.service.SomethingWrongException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aop.xml" })
public class ExMechanicTest {
    @Autowired
    private CarMechanicService carMechanicService;

    @Test(expected = SomethingWrongException.class)
    public void test() throws SomethingWrongException {
        carMechanicService.checkVehicleStart();
    }

    @Test(expected = RuntimeException.class)
    public void test1() {
        carMechanicService.checkEx();

    }

}