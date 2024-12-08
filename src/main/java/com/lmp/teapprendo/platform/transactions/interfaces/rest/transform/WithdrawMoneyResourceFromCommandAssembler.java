package com.lmp.teapprendo.platform.transactions.interfaces.rest.transform;

import com.lmp.teapprendo.platform.transactions.domain.commands.WithdrawMoney;
import com.lmp.teapprendo.platform.transactions.interfaces.rest.resources.WithdrawMoneyResource;

public class WithdrawMoneyResourceFromCommandAssembler {
    public static WithdrawMoneyResource toResourceFromDepositMoney(WithdrawMoney command) {
        return new WithdrawMoneyResource(
            command.getTransactionId(),
            command.getAccountId(),
            command.getAmount(),
            command.getCreatedAt());
    }
}
