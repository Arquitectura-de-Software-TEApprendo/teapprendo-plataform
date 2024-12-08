package com.lmp.teapprendo.platform.clients.interfaces.rest.resources;

import com.lmp.teapprendo.platform.clients.domain.projections.ClientProjection;
import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Error;
import java.util.List;

public record GetClientsResponseResource(
    List<ClientProjection> success,
    List<Error> errors
) {}
