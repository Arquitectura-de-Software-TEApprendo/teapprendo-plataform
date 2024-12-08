package com.lmp.teapprendo.platform.transactions.interfaces.rest.resources;

import com.lmp.teapprendo.platform.transactions.domain.model.aggregates.TransactionStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WithdrawResource(
    Long transactionId,
    Long accountId,
    BigDecimal amount,
    TransactionStatus status,
    LocalDateTime createdAt
) {}
