package com.lmp.teapprendo.platform.curricular.interfaces.eventhandlers;

import com.lmp.teapprendo.platform.curricular.domain.events.TeachingUnitEdited;
import com.lmp.teapprendo.platform.curricular.domain.events.TeachingUnitRegistered;
import com.lmp.teapprendo.platform.curricular.domain.model.valueobjects.TeachingUnitStatus;
import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitProjection;
import com.lmp.teapprendo.platform.curricular.repositories.TeachingUnitRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeachingUnitProjectionsEventHandler {
    private final TeachingUnitRepository teachingUnitRepository;

    public TeachingUnitProjectionsEventHandler(TeachingUnitRepository teachingUnitRepository) {
        this.teachingUnitRepository = teachingUnitRepository;
    }

    @EventHandler
    public void on(TeachingUnitRegistered event) {
        TeachingUnitProjection teachingUnit = new TeachingUnitProjection(
                event.getId(),
                event.getName(),
                event.getDuration(),
                event.getPurpose(),
                TeachingUnitStatus.ACTIVE.name(),
                event.getCreatedAt());
        teachingUnitRepository.save(teachingUnit);
    }

    @EventHandler
    public void on(TeachingUnitEdited event) {
        Optional<TeachingUnitProjection> viewOptional = teachingUnitRepository.findById(event.getId());
        if (viewOptional.isPresent()) {
            TeachingUnitProjection view = viewOptional.get();
            view.setName(event.getName());
            view.setDuration(event.getDuration());
            view.setPurpose(event.getPurpose());
            view.setUpdatedAt(event.getUpdatedAt());
            teachingUnitRepository.save(view);
        }
    }
}
