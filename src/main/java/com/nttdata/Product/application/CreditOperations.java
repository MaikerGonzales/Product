package com.nttdata.Product.application;

import com.nttdata.Product.domain.Credit;
import com.nttdata.Product.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditOperations {

    public Mono<Credit> create(Credit credit);
    public Mono<Credit> update(String id, Credit credit);
    public Mono<CreditDao> delete(String id);
    public Mono<Credit> findById(String id);
    public Flux<Credit> findAll();

}
