package com.buginsight.benildo.buginsight_benildo_api.dto;

import com.buginsight.benildo.buginsight_benildo_api.enums.BugSeverity;
import com.buginsight.benildo.buginsight_benildo_api.enums.BugStatus;

import java.time.LocalDateTime;

public record BugResponseDTO (
        Long id,
        String title,
        String description,
        String stackTrace,
        BugSeverity severity,
        BugStatus status,
        String aiAnalysis,
        LocalDateTime createdAt
){}