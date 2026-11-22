package com.buginsight.benildo.buginsight_benildo_api.entity;

import com.buginsight.benildo.buginsight_benildo_api.enums.BugSeverity;
import com.buginsight.benildo.buginsight_benildo_api.enums.BugStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bugs")
@Getter
@Setter
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private  String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String stackTrace;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BugSeverity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BugStatus status;

    @Column(columnDefinition = "TEXT")
    private String aiAnalysis;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        if (status == null){
            status = BugStatus.OPEN;
        }
    }


}
