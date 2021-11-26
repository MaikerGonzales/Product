package com.nttdata.Product.infraestructure.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("account")
public class AccountDao {

    @Id
    private String accountId;
    private String accountName;
    private String accountType;
    private Long accountCommission;
    private Integer accountLimitMovement;

}
