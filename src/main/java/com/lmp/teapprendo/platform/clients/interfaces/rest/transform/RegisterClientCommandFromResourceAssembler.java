package com.lmp.teapprendo.platform.clients.interfaces.rest.transform;

import com.lmp.teapprendo.platform.clients.domain.commands.RegisterClient;
import com.lmp.teapprendo.platform.clients.interfaces.rest.resources.RegisterClientResource;

public class RegisterClientCommandFromResourceAssembler {
    public static RegisterClient toCommandFromResource(RegisterClientResource resource) {
        return new RegisterClient(
                resource.id(),
                resource.firstName(),
                resource.lastName(),
                resource.dni(),
                resource.createdAt());
    }
}
