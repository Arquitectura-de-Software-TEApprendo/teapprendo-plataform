package com.lmp.teapprendo.platform.clients.interfaces.rest.transform;

import com.lmp.teapprendo.platform.clients.domain.commands.EditClient;
import com.lmp.teapprendo.platform.clients.domain.commands.RegisterClient;
import com.lmp.teapprendo.platform.clients.interfaces.rest.resources.ClientResource;

public class ClientResourceFromCommandAssembler {
    public static ClientResource toResourceFromRegisterClient(RegisterClient command) {
        return new ClientResource(
            command.getId(),
            command.getFirstName(),
            command.getLastName(),
            command.getDni());
    }

    public static ClientResource toResourceFromEditClient(EditClient command) {
        return new ClientResource(
                command.getId(),
                command.getFirstName(),
                command.getLastName(),
                command.getDni());
    }
}
