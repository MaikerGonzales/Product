package com.nttdata.Product.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("credit")
public class CreditDao {

    private String creditId;
    private String creditName;
    private String creditType;
    private Integer creditMaximumNumber;
    private String creditCardNumber;
    private String creditLimit;

}
