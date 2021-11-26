package com.nttdata.Product.infraestructure.repository;

import com.nttdata.Product.application.model.CreditRepository;
import com.nttdata.Product.domain.Credit;
import com.nttdata.Product.infraestructure.model.dao.CreditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CreditCrudRepository implements CreditRepository {

    @Autowired
    ICreditCrudRepository repository;

    @Override
    public Mono<Credit> create(Credit credit) {
        return repository.save(mapCreditToCreditDao(credit))
                .map(this::mapCreditDaoToCredit);
    }

    @Override
    public Mono<Credit> update(String id, Credit credit) {
        return repository.findById(id)
                .flatMap(p -> create(mapCreditDaoToCredit(p, credit)));
    }

    @Override
    public Mono<CreditDao> delete(String id) {
        return repository.findById(id)
                .flatMap(p -> repository.deleteById(p.getCreditId()).thenReturn(p));
    }

    @Override
    public Mono<Credit> findById(String id) {
        return repository.findById(id)
                .map(this::mapCreditDaoToCredit);
    }

    @Override
    public Flux<Credit> findAll() {
        return repository.findAll()
                .map(this::mapCreditDaoToCredit);
    }

    private CreditDao mapCreditToCreditDao (Credit credit){
        CreditDao creditDao = new CreditDao();
        creditDao.setCreditId(credit.getCreditId());
        creditDao.setCreditName(credit.getCreditName());
        creditDao.setCreditType(credit.getCreditType());
        creditDao.setCreditMaximumNumber(credit.getCreditMaximumNumber());
        creditDao.setCreditCardNumber(credit.getCreditCardNumber());
        creditDao.setCreditLimit(credit.getCreditLimit());
        return creditDao;
    }

    private Credit mapCreditDaoToCredit (CreditDao creditDao){
        Credit credit = new Credit();
        credit.setCreditId(creditDao.getCreditId());
        credit.setCreditName(creditDao.getCreditName());
        credit.setCreditType(creditDao.getCreditType());
        credit.setCreditMaximumNumber(creditDao.getCreditMaximumNumber());
        credit.setCreditCardNumber(creditDao.getCreditCardNumber());
        credit.setCreditLimit(creditDao.getCreditLimit());
        return credit;
    }

    private Credit mapCreditDaoToCredit (CreditDao creditDao, Credit credit){
        credit.setCreditId(creditDao.getCreditId());
        return credit;
    }

}
