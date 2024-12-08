package com.lmp.teapprendo.platform.clients.interfaces.eventhandlers;

import com.lmp.teapprendo.platform.clients.domain.events.ClientEdited;
import com.lmp.teapprendo.platform.clients.domain.events.ClientRegistered;
import com.lmp.teapprendo.platform.clients.domain.model.valueobjects.ClientStatus;
import com.lmp.teapprendo.platform.clients.domain.projections.ClientProjection;
import com.lmp.teapprendo.platform.clients.infrastructure.persistence.jpa.repositories.ClientRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ClientProjectionsEventHandler {
    private final ClientRepository clientRepository;

    public ClientProjectionsEventHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @EventHandler
    public void on(ClientRegistered event) {
        ClientProjection client = new ClientProjection(
            event.getId(),
            event.getFirstName(),
            event.getLastName(),
            event.getDni(),
            ClientStatus.ACTIVE.name(),
            event.getCreatedAt());
        clientRepository.save(client);
    }

    @EventHandler
    public void on(ClientEdited event) {
        Optional<ClientProjection> viewOptional = clientRepository.findById(event.getId());
        if (viewOptional.isPresent()) {
            ClientProjection view = viewOptional.get();
            view.setFirstName(event.getFirstName());
            view.setLastName(event.getLastName());
            view.setDni(event.getDni());
            view.setUpdatedAt(event.getUpdatedAt());
            clientRepository.save(view);
        }
    }
}
