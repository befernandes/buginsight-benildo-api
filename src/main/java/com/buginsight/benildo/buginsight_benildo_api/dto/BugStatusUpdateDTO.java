package com.buginsight.benildo.buginsight_benildo_api.dto;

import com.buginsight.benildo.buginsight_benildo_api.enums.BugStatus;
import jakarta.validation.constraints.NotNull;

public record BugStatusUpdateDTO(

    @NotNull(message = "Status is required")
    BugStatus status

) {}
