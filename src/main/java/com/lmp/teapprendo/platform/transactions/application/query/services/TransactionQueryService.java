package com.lmp.teapprendo.platform.transactions.application.query.services;

import com.lmp.teapprendo.platform.accounts.domain.projections.AccountProjection;
import com.lmp.teapprendo.platform.accounts.domain.projections.AccountAuditLogProjection;
import com.lmp.teapprendo.platform.accounts.domain.queries.GetAccountAuditLogsByAccountId;
import com.lmp.teapprendo.platform.accounts.domain.queries.GetAccounts;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionQueryService {
    private final QueryGateway queryGateway;

    public TransactionQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<AccountAuditLogProjection> getAuditLogsByAccountId(Long accountId) throws Exception {
        var query = new GetAccountAuditLogsByAccountId(accountId);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(AccountAuditLogProjection.class)).join();
    }

    public List<AccountProjection> getAccounts(Integer page, Integer limit) throws Exception {
        var query = new GetAccounts(page, limit);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(AccountProjection.class)).join();
    }
}
