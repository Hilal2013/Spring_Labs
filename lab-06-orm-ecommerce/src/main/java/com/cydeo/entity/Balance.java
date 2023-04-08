package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  //  @JoinColumn(name = "customer_id")
    private Customer customer;
    public Balance(BigDecimal amount) {
        this.amount = amount;
    }
}
