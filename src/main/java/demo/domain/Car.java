package demo.domain;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("Car Entry")
public class Car {
    @ApiModelProperty(value = "name", required = true)
    private String name;
    @ApiModelProperty(value = "age", required = true)
    private String age;
}
