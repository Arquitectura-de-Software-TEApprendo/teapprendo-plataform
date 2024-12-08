package com.lmp.teapprendo.platform.curricular.application.queryservices;

import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitAuditLogProjection;
import com.lmp.teapprendo.platform.curricular.domain.projections.TeachingUnitProjection;
import com.lmp.teapprendo.platform.curricular.domain.queries.GetTeachingUnitAuditLogsByTeachingUnitId;
import com.lmp.teapprendo.platform.curricular.domain.queries.GetTeachingUnits;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeachingUnitQueryService {
    private final QueryGateway queryGateway;

    public TeachingUnitQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<TeachingUnitAuditLogProjection> getAuditLogsByTeachingUnitId(Long teachingUnitId) throws Exception {
        var query = new GetTeachingUnitAuditLogsByTeachingUnitId(teachingUnitId);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(TeachingUnitAuditLogProjection.class)).join();
    }

    public List<TeachingUnitProjection> getTeachingUnits(Integer page, Integer limit) throws Exception {
        var query = new GetTeachingUnits(page, limit);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(TeachingUnitProjection.class)).join();
    }
}
