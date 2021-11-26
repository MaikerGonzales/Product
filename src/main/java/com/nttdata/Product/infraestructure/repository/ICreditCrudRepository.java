package com.nttdata.Product.infraestructure.repository;

import com.nttdata.Product.infraestructure.model.dao.CreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ICreditCrudRepository extends ReactiveCrudRepository<CreditDao, String> {

}
