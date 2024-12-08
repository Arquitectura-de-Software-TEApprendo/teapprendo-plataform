package com.lmp.teapprendo.platform.transactions.domain.events;

import lombok.Value;
import java.time.LocalDateTime;

@Value
public class DepositCompleted {
    private Long transactionId;
    private LocalDateTime updatedAt;
}
