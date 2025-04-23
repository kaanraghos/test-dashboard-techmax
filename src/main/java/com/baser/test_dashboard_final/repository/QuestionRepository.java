package com.baser.test_dashboard_final.repository;

import com.baser.test_dashboard_final.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
