package com.nttdata.Product.infraestructure.rest;

import com.nttdata.Product.application.CreditOperations;
import com.nttdata.Product.domain.Credit;
import com.nttdata.Product.infraestructure.model.dao.CreditDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditOperations creditOperations;

    @GetMapping
    public Flux<Credit> getAll(){
        return creditOperations.findAll();
    }

    @GetMapping("/{creditId}")
    public Mono<Credit> getById(@PathVariable String creditId){
        return creditOperations.findById(creditId);
    }

    @PostMapping
    public Mono<Credit> post(@RequestBody Credit credit){
        return creditOperations.create(credit);
    }

    @PutMapping("/{creditId}")
    public Mono<Credit> put(@PathVariable String creditId, @RequestBody Credit credit){
        return creditOperations.update(creditId,credit);
    }

    @DeleteMapping("/{id}")
    public Mono<CreditDao> delete(@PathVariable String id){
        return creditOperations.delete(id);
    }

}
