package com.lmp.teapprendo.platform.transactions.interfaces.rest.transform;

import com.lmp.teapprendo.platform.transactions.domain.commands.WithdrawMoney;
import com.lmp.teapprendo.platform.transactions.interfaces.rest.resources.WithdrawMoneyResource;

public class WithdrawMoneyCommandFromResourceAssembler {
    public static WithdrawMoney toCommandFromResource(WithdrawMoneyResource resource) {
        return new WithdrawMoney(
            resource.transactionId(),
            resource.accountId(),
            resource.amount(),
            resource.createdAt()
        );
    }
}
