package com.lmp.teapprendo.platform.transactions.domain.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.time.LocalDateTime;

@Value
public class MarkDepositAsCompleted {
    @TargetAggregateIdentifier
    private Long transactionId;
    private LocalDateTime updatedAt;
}
