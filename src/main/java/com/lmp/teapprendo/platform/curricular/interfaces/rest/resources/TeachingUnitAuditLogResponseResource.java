package com.lmp.teapprendo.platform.curricular.interfaces.rest.resources;

import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitAuditLogProjection;
import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;

import java.util.List;

public record TeachingUnitAuditLogResponseResource(
    List<TeachingUnitAuditLogProjection> success,
    List<Error> errors
) {}
