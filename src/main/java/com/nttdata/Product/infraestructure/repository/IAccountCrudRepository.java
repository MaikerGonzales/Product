package com.nttdata.Product.infraestructure.repository;

import com.nttdata.Product.infraestructure.model.dao.AccountDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IAccountCrudRepository extends ReactiveCrudRepository<AccountDao, String> {

}
