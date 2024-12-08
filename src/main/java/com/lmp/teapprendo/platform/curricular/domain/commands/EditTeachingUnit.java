package com.lmp.teapprendo.platform.curricular.domain.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;

@Value
public class EditTeachingUnit {
    @TargetAggregateIdentifier
    private Long id;
    private String name;
    private String duration;
    private String purpose;
    private LocalDateTime updatedAt;
}
