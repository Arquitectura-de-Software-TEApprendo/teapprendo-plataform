package com.lmp.teapprendo.platform.accounts.domain.events;

import lombok.Value;
import java.time.LocalDateTime;

@Value
public class AccountNotFound {
    private Long transactionId;
    private LocalDateTime createdAt;
}
