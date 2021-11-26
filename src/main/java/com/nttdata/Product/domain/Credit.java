package com.nttdata.Product.domain;

import lombok.Data;

@Data
public class Credit {

    private String creditId;
    private String creditName;
    private String creditType;
    private Integer creditMaximumNumber;
    private String creditCardNumber;
    private String creditLimit;

}
