package com.nttdata.Product.domain;

import lombok.Data;

@Data
public class Account {

    private String accountId;
    private String accountName;
    private String accountType;
    private Long accountCommission;
    private Integer accountLimitMovement;

}
