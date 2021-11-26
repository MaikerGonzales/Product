package com.nttdata.Product.application.model;

import com.nttdata.Product.domain.Account;
import com.nttdata.Product.infraestructure.model.dao.AccountDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    public Mono<Account> create(Account account);
    public Mono<Account> update(String id, Account account);
    public Mono<AccountDao> delete(String id);
    public Mono<Account> findById(String id);
    public Flux<Account> findAll();

}
