package com.lmp.teapprendo.platform.accounts.interfaces.rest.resources;

import com.lmp.teapprendo.platform.accounts.domain.projections.AccountProjection;
import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;

import java.util.List;

public record GetAccountsResponseResource(
    List<AccountProjection> success,
    List<Error> errors
) {}
