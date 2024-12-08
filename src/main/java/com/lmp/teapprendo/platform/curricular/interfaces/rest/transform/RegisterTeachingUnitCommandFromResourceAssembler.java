package com.lmp.teapprendo.platform.curricular.interfaces.rest.transform;

import com.lmp.teapprendo.platform.curricular.domain.commands.RegisterTeachingUnit;
import com.lmp.teapprendo.platform.curricular.interfaces.rest.resources.RegisterTeachingUnitResource;

public class RegisterTeachingUnitCommandFromResourceAssembler {
    public static RegisterTeachingUnit toCommandFromResource(RegisterTeachingUnitResource resource) {
        return new RegisterTeachingUnit(
                resource.id(),
                resource.name(),
                resource.duration(),
                resource.purpose(),
                resource.createdAt());
    }
}
