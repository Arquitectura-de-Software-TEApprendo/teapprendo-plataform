package com.lmp.teapprendo.platform.transactions.interfaces.rest.resources;

import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;
import java.util.List;

public record TransferMoneyResponseResource(
        TransferMoneyResource success,
        List<Error> errors
) {}
