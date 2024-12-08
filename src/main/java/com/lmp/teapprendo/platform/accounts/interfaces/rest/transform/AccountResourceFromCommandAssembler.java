package com.lmp.teapprendo.platform.accounts.interfaces.rest.transform;

import com.lmp.teapprendo.platform.accounts.domain.commands.EditAccount;
import com.lmp.teapprendo.platform.accounts.domain.commands.OpenAccount;
import com.lmp.teapprendo.platform.accounts.interfaces.rest.resources.AccountEditedResource;
import com.lmp.teapprendo.platform.accounts.interfaces.rest.resources.AccountResource;
import java.math.BigDecimal;

public class AccountResourceFromCommandAssembler {
    public static AccountResource toResourceFromOpenAccount(OpenAccount command) {
        return new AccountResource(
            command.getId(),
            command.getNumber(),
            BigDecimal.ZERO,
            command.getOverdraftLimit(),
            command.getClientId());
    }

    public static AccountEditedResource toResourceFromEditClient(EditAccount command) {
        return new AccountEditedResource(
                command.getId(),
                command.getOverdraftLimit(),
                command.getUpdatedAt());
    }
}
