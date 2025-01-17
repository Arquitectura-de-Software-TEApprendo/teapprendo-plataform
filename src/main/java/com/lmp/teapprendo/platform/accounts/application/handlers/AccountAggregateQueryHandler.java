package com.lmp.teapprendo.platform.accounts.application.handlers;

import com.lmp.teapprendo.platform.accounts.domain.projections.AccountProjection;
import com.lmp.teapprendo.platform.accounts.domain.projections.AccountAuditLogProjection;
import com.lmp.teapprendo.platform.accounts.domain.queries.GetAccountAuditLogsByAccountId;
import com.lmp.teapprendo.platform.accounts.domain.queries.GetAccountById;
import com.lmp.teapprendo.platform.accounts.domain.queries.GetAccountByNumber;
import com.lmp.teapprendo.platform.accounts.domain.queries.GetAccounts;
import com.lmp.teapprendo.platform.accounts.infrastructure.persistence.jpa.repositories.AccountAuditLogRepository;
import com.lmp.teapprendo.platform.accounts.infrastructure.persistence.jpa.repositories.AccountRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class AccountAggregateQueryHandler {
    private final AccountRepository accountRepository;
    private final AccountAuditLogRepository accountAuditLogRepository;

    public AccountAggregateQueryHandler(AccountRepository accountRepository, AccountAuditLogRepository accountAuditLogRepository) {
        this.accountRepository = accountRepository;
        this.accountAuditLogRepository = accountAuditLogRepository;
    }

    @QueryHandler
    public List<AccountProjection> handle(GetAccounts query) {
        return this.accountRepository.getAccounts(query.getPage(), query.getLimit());
    }

    @QueryHandler
    public Optional<AccountProjection> handle(GetAccountById query) {
        return this.accountRepository.findById(query.getId());
    }

    @QueryHandler
    public Optional<AccountProjection> handle(GetAccountByNumber query) {
        return this.accountRepository.getByNumber(query.getNumber());
    }

    @QueryHandler
    public List<AccountAuditLogProjection> handle(GetAccountAuditLogsByAccountId query) {
        return this.accountAuditLogRepository.getByAccountId(query.getId());
    }
}
