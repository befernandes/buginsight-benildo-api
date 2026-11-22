package com.buginsight.benildo.buginsight_benildo_api.dto;

import com.buginsight.benildo.buginsight_benildo_api.enums.BugSeverity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BugRequestDTO (

        @NotBlank(message = "Title is required")
        @Size(max = 150, message = "Title must have at most 150 characters")
        String title,

        @NotBlank(message = "Description is required")
        @Size(max = 2000, message = "Description must have at most 2000 characters")
        String description,

        String stackTrace,

        @NotNull(message = "Severity is required")
        BugSeverity severity
){
}
