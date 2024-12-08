package com.lmp.teapprendo.platform.accounts.interfaces.rest.transform;

import com.lmp.teapprendo.platform.accounts.domain.commands.OpenAccount;
import com.lmp.teapprendo.platform.accounts.interfaces.rest.resources.OpenAccountResource;

public class OpenAccountCommandFromResourceAssembler {
    public static OpenAccount toCommandFromResource(OpenAccountResource resource) {
        return new OpenAccount(
            resource.id(),
            resource.number(),
            resource.overdraftLimit(),
            resource.clientId(),
            resource.createdAt());
    }
}
