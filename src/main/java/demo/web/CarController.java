package demo.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import demo.domain.Car;

@RestController
@Slf4j
@Api(value = "hello api", description = "sample test")
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CarController {

    @RequestMapping("/car")
    @ApiOperation(httpMethod = "GET", value = "retrieve a car", response = Car.class)
    public Car car() {
        return new Car("bmw", "10");
    }
}