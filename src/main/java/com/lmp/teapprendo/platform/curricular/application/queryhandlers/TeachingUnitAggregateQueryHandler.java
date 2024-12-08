package com.lmp.teapprendo.platform.curricular.application.queryhandlers;

import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitAuditLogProjection;
import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitProjection;
import com.lmp.teapprendo.platform.curricular.domain.queries.GetTeachingUnitAuditLogsByTeachingUnitId;
import com.lmp.teapprendo.platform.curricular.domain.queries.GetTeachingUnits;
import com.lmp.teapprendo.platform.curricular.repositories.TeachingUnitAuditLogRepository;
import com.lmp.teapprendo.platform.curricular.repositories.TeachingUnitRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeachingUnitAggregateQueryHandler {
    private final TeachingUnitRepository teachingUnitRepository;
    private final TeachingUnitAuditLogRepository teachingUnitAuditRepository;


    public TeachingUnitAggregateQueryHandler(TeachingUnitRepository teachingUnitRepository, TeachingUnitAuditLogRepository teachingUnitAuditRepository) {
        this.teachingUnitRepository = teachingUnitRepository;
        this.teachingUnitAuditRepository = teachingUnitAuditRepository;
    }

    @QueryHandler
    public List<TeachingUnitAuditLogProjection> handle(GetTeachingUnitAuditLogsByTeachingUnitId query) {
        return this.teachingUnitAuditRepository.getByTeachingUnitId(query.getId());
    }

    @QueryHandler
    public List<TeachingUnitProjection> handle(GetTeachingUnits query) {
        return this.teachingUnitRepository.getPaginated(query.getPage(), query.getLimit());
    }
}
