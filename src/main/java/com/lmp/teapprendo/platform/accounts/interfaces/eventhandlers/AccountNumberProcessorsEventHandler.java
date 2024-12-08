package com.lmp.teapprendo.platform.accounts.interfaces.eventhandlers;

import com.lmp.teapprendo.platform.accounts.domain.events.AccountOpened;
import com.lmp.teapprendo.platform.accounts.domain.processors.AccountNumber;
import com.lmp.teapprendo.platform.accounts.infrastructure.persistence.jpa.repositories.AccountNumberRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("accountNumber")
public class AccountNumberProcessorsEventHandler {
    private final AccountNumberRepository accountNumberRepository;

    public AccountNumberProcessorsEventHandler(AccountNumberRepository accountNumberRepository) {
        this.accountNumberRepository = accountNumberRepository;
    }

    @EventHandler
    public void on(AccountOpened event) {
        accountNumberRepository.save(new AccountNumber(event.getId(), event.getNumber()));
    }
}