package com.baser.test_dashboard_final.service;

import com.baser.test_dashboard_final.entity.Option;
import com.baser.test_dashboard_final.entity.Question;
import com.baser.test_dashboard_final.entity.Test;
import com.baser.test_dashboard_final.entity.TestResult;
import com.baser.test_dashboard_final.repository.TestRepository;
import com.baser.test_dashboard_final.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestResultRepository testResultRepository;

    public TestResult solveTest(Long testId, List<Long> selectedOptionIds) {
        Optional<Test> optionalTest = testRepository.findById(testId);
        if (optionalTest.isEmpty()) {
            throw new RuntimeException("Test not found");
        }

        Test test = optionalTest.get();
        List<Question> questions = test.getQuestions();
        int correctCount = 0;

        for (Question question : questions) {
            for (Option option : question.getOptions()) {
                if (selectedOptionIds.contains(option.getId()) && option.isCorrect()) {
                    correctCount++;
                }
            }
        }

        double score = (double) correctCount / questions.size() * 100;

        TestResult result = new TestResult();
        result.setScore(score);
        result.setCompletedAt(java.time.LocalDateTime.now());

        testResultRepository.save(result);
        return result;
    }
}
