package com.lmp.teapprendo.platform.accounts.domain.commands;

import com.lmp.teapprendo.platform.transactions.domain.model.valueobjects.TransactionType;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class DebitAccount {
    @TargetAggregateIdentifier
    private Long accountId;
    private Long transactionId;
    private BigDecimal amount;
    private TransactionType transactionType;
    private LocalDateTime updatedAt;
}
