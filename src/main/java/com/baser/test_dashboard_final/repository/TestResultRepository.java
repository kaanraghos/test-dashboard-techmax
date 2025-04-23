package com.baser.test_dashboard_final.repository;

import com.baser.test_dashboard_final.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
