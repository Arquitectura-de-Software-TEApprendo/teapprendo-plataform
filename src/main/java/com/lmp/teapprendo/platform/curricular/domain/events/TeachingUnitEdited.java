package com.lmp.teapprendo.platform.curricular.domain.events;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TeachingUnitEdited {
    private Long id;
    private String name;
    private String duration;
    private String purpose;
    private LocalDateTime updatedAt;
}
