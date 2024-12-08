package com.lmp.teapprendo.platform.curricular.interfaces.rest.resources;

import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitProjection;
import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;

import java.util.List;

public record GetTeachingUnitsResponseResource(
    List<TeachingUnitProjection> success,
    List<Error> errors
) {}
