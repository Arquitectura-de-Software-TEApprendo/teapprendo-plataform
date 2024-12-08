package com.lmp.teapprendo.platform.curricular.interfaces.rest.transform;

import com.lmp.teapprendo.platform.curricular.domain.commands.EditTeachingUnit;
import com.lmp.teapprendo.platform.curricular.domain.commands.RegisterTeachingUnit;
import com.lmp.teapprendo.platform.curricular.interfaces.rest.resources.TeachingUnitResource;

public class TeachingUnitResourceFromCommandAssembler {
    public static TeachingUnitResource toResourceFromRegisterTeachingUnit(RegisterTeachingUnit command) {
        return new TeachingUnitResource(
            command.getId(),
            command.getName(),
            command.getDuration(),
            command.getPurpose());
    }

    public static TeachingUnitResource toResourceFromEditTeachingUnit(EditTeachingUnit command) {
        return new TeachingUnitResource(
                command.getId(),
                command.getName(),
                command.getDuration(),
                command.getPurpose());
    }
}
