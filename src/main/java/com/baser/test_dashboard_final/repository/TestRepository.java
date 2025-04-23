package com.baser.test_dashboard_final.repository;

import com.baser.test_dashboard_final.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
