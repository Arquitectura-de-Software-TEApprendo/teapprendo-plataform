package com.lmp.teapprendo.platform.clients.interfaces.rest.resources;

import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;
import java.util.List;

public record EditClientResponseResource(
        ClientResource success,
        List<Error> errors
) {}
