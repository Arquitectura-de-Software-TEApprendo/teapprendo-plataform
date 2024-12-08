package com.lmp.teapprendo.platform.accounts.interfaces.rest.resources;

import com.lmp.teapprendo.platform.accounts.domain.projections.AccountAuditLogProjection;
import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;

import java.util.List;

public record AccountAuditLogResponseResource(
    List<AccountAuditLogProjection> success,
    List<Error> errors
) {}
