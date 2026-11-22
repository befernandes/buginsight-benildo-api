package com.buginsight.benildo.buginsight_benildo_api.repository;

import com.buginsight.benildo.buginsight_benildo_api.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {
}
