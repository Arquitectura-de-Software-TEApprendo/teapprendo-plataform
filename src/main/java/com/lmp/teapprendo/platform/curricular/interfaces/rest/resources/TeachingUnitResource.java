package com.lmp.teapprendo.platform.curricular.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TeachingUnitResource (
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id,
    String name,
    String duration,
    String purpose
) {}
