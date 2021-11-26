package com.nttdata.Product.application.impl;

import com.nttdata.Product.application.AccountOperations;
import com.nttdata.Product.application.model.AccountRepository;
import com.nttdata.Product.domain.Account;
import com.nttdata.Product.infraestructure.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountOperationsImpl implements AccountOperations {

    @Autowired
    AccountRepository repository;


    @Override
    public Mono<Account> create(Account account) {
        return repository.create(account);
    }

    @Override
    public Mono<Account> update(String id, Account account) {
        return repository.update(id, account);
    }

    @Override
    public Mono<AccountDao> delete(String id) {
        return repository.delete(id);
    }

    @Override
    public Mono<Account> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Account> findAll() {
        return repository.findAll();
    }
}
