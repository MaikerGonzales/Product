package com.nttdata.Product.infraestructure.repository;

import com.nttdata.Product.application.model.AccountRepository;
import com.nttdata.Product.domain.Account;
import com.nttdata.Product.infraestructure.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AccountCrudRepository implements AccountRepository {

    @Autowired
    IAccountCrudRepository repository;

    @Override
    public Mono<Account> create(Account account) {
        return repository.save(mapAccountToAccountDao(account))
                .map(this::mapAccountDaoToAccount);
    }

    @Override
    public Mono<Account> update(String id, Account account) {
        return repository.findById(id)
                .flatMap(p -> create(mapAccountDaoToAccount(p, account)));
    }

    @Override
    public Mono<AccountDao> delete(String id) {
        return repository.findById(id)
                .flatMap(p -> repository.deleteById(p.getAccountId()).thenReturn(p));
    }

    @Override
    public Mono<Account> findById(String id) {
        return repository.findById(id)
                .map(this::mapAccountDaoToAccount);
    }

    @Override
    public Flux<Account> findAll() {
        return repository.findAll()
                .map(this::mapAccountDaoToAccount);
    }

    private AccountDao mapAccountToAccountDao (Account account){
        AccountDao accountDao = new AccountDao();
        accountDao.setAccountId(account.getAccountId());
        accountDao.setAccountName(account.getAccountName());
        accountDao.setAccountType(account.getAccountType());
        accountDao.setAccountCommission(account.getAccountCommission());
        accountDao.setAccountLimitMovement(account.getAccountLimitMovement());
        return accountDao;
    }

    private Account mapAccountDaoToAccount (AccountDao accountDao){
        Account account = new Account();
        account.setAccountId(accountDao.getAccountId());
        account.setAccountName(accountDao.getAccountName());
        account.setAccountType(accountDao.getAccountType());
        account.setAccountCommission(accountDao.getAccountCommission());
        account.setAccountLimitMovement(accountDao.getAccountLimitMovement());
        return account;
    }

    private Account mapAccountDaoToAccount (AccountDao accountDao, Account account){
        account.setAccountId(accountDao.getAccountId());
        return account;
    }
}
