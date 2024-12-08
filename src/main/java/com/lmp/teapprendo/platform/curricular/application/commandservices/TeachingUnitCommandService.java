package com.lmp.teapprendo.platform.curricular.application.commandservices;

import com.lmp.teapprendo.platform.curricular.application.validators.EditTeachingUnitValidator;
import com.lmp.teapprendo.platform.curricular.application.validators.RegisterTeachingUnitValidator;
import com.lmp.teapprendo.platform.curricular.domain.commands.EditTeachingUnit;
import com.lmp.teapprendo.platform.curricular.domain.commands.RegisterTeachingUnit;
import com.lmp.teapprendo.platform.shared.domain.model.valueobjects.Notification;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
public class TeachingUnitCommandService {
    private final CommandGateway commandGateway;
    private final RegisterTeachingUnitValidator registerTeachingUnitValidator;
    private final EditTeachingUnitValidator editTeachingUnitValidator;

    public TeachingUnitCommandService(CommandGateway commandGateway, RegisterTeachingUnitValidator registerTeachingUnitValidator, EditTeachingUnitValidator editTeachingUnitValidator) {
        this.commandGateway = commandGateway;
        this.registerTeachingUnitValidator = registerTeachingUnitValidator;
        this.editTeachingUnitValidator = editTeachingUnitValidator;
    }

    public Notification register(RegisterTeachingUnit command) throws Exception {
        Notification notification = this.registerTeachingUnitValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }

    public Notification edit(EditTeachingUnit command) throws Exception {
        Notification notification = this.editTeachingUnitValidator.validate(command);
        if (notification.hasErrors()) return notification;
        commandGateway.sendAndWait(command);
        return notification;
    }
}
