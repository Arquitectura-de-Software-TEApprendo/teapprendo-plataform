package com.lmp.teapprendo.platform.clients.interfaces.rest.transform;

import com.lmp.teapprendo.platform.clients.domain.commands.EditClient;
import com.lmp.teapprendo.platform.clients.interfaces.rest.resources.EditClientResource;

public class EditClientCommandFromResourceAssembler {
    public static EditClient toCommandFromResource(EditClientResource resource) {
        return new EditClient(
            resource.id(),
            resource.firstName(),
            resource.lastName(),
            resource.dni(),
            resource.updatedAt());
    }
}
