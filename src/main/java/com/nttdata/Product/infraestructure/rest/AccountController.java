package com.nttdata.Product.infraestructure.rest;

import com.nttdata.Product.application.AccountOperations;
import com.nttdata.Product.domain.Account;
import com.nttdata.Product.infraestructure.model.dao.AccountDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountOperations accountOperations;

    @GetMapping
    public Flux<Account> getAll(){
        return accountOperations.findAll();
    }

    @GetMapping("/{accountId}")
    public Mono<Account> getById(@PathVariable String accountId){
        return accountOperations.findById(accountId);
    }

    @PostMapping
    public Mono<Account> post(@RequestBody Account account){
        return accountOperations.create(account);
    }

    @PutMapping("/{accountId}")
    public Mono<Account> put(@PathVariable String accountId, @RequestBody Account account){
        return accountOperations.update(accountId,account);
    }

    @DeleteMapping("/{id}")
    public Mono<AccountDao> delete(@PathVariable String id){
        return accountOperations.delete(id);
    }

}
