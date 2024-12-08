package com.lmp.teapprendo.platform.curricular.interfaces.rest.resources;

import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;

import java.util.List;

public record RegisterTeachingUnitResponseResource(
        TeachingUnitResource success,
        List<Error> errors
) {}
