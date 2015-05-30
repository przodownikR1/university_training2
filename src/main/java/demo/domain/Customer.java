package demo.domain;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends PKEntity{

    private static final long serialVersionUID = 2669340231494998572L;

    private String name;
    private int age;
    private BigDecimal salary;
    @Embedded
    private Address address;
    @Enumerated
    private Sex sex;
    
}
