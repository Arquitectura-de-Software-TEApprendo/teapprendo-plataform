package com.lmp.teapprendo.platform.curricular.interfaces.eventhandlers;

import com.lmp.teapprendo.platform.curricular.domain.events.TeachingUnitEdited;
import com.lmp.teapprendo.platform.curricular.domain.events.TeachingUnitRegistered;
import com.lmp.teapprendo.platform.curricular.domain.model.valueobjects.TeachingUnitStatus;
import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitAuditLogProjection;
import com.lmp.teapprendo.platform.curricular.repositories.TeachingUnitAuditLogRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeachingUnitAuditLogProjectionsEventHandler {
    private final TeachingUnitAuditLogRepository teachingUnitAuditRepository;

    public TeachingUnitAuditLogProjectionsEventHandler(TeachingUnitAuditLogRepository teachingUnitAuditRepository) {
        this.teachingUnitAuditRepository = teachingUnitAuditRepository;
    }

    @EventHandler
    public void on(TeachingUnitRegistered event) {
        TeachingUnitAuditLogProjection view = new TeachingUnitAuditLogProjection(
                event.getId(),
                event.getName(),
                event.getDuration(),
                event.getPurpose(),
                TeachingUnitStatus.ACTIVE.name(),
                event.getCreatedAt());
        teachingUnitAuditRepository.save(view);
    }

    @EventHandler
    public void on(TeachingUnitEdited event) {
        Optional<TeachingUnitAuditLogProjection> viewOptional = teachingUnitAuditRepository.getLastByTeachingUnitId(event.getId());
        if (viewOptional.isPresent()) {
            TeachingUnitAuditLogProjection lastTeachingUnitAudit = viewOptional.get();
            TeachingUnitAuditLogProjection teachingUnitAudit = new TeachingUnitAuditLogProjection(lastTeachingUnitAudit);
            teachingUnitAudit.setName(event.getName());
            teachingUnitAudit.setDuration(event.getDuration());
            teachingUnitAudit.setPurpose(event.getPurpose());
            teachingUnitAudit.setCreatedAt(event.getUpdatedAt());
            teachingUnitAuditRepository.save(teachingUnitAudit);
        }
    }
}
