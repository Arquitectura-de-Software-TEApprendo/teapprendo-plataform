package com.lmp.teapprendo.platform.curricular.interfaces.rest.transform;

import com.lmp.teapprendo.platform.curricular.domain.commands.EditTeachingUnit;
import com.lmp.teapprendo.platform.curricular.interfaces.rest.resources.EditTeachingUnitResource;

public class EditTeachingUnitCommandFromResourceAssembler {
    public static EditTeachingUnit toCommandFromResource(EditTeachingUnitResource resource) {
        return new EditTeachingUnit(
            resource.id(),
            resource.name(),
            resource.duration(),
            resource.purpose(),
            resource.updatedAt());
    }
}
