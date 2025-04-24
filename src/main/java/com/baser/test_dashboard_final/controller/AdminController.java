package com.baser.test_dashboard_final.controller;

import com.baser.test_dashboard_final.entity.Option;
import com.baser.test_dashboard_final.entity.Question;
import com.baser.test_dashboard_final.entity.Test;
import com.baser.test_dashboard_final.repository.QuestionRepository;
import com.baser.test_dashboard_final.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final QuestionRepository questionRepository;

    private final TestRepository testRepository;

    @Autowired
    public AdminController(QuestionRepository questionRepository, TestRepository testRepository) {
        this.questionRepository = questionRepository;
        this.testRepository = testRepository;
    }


    @PostMapping("/add-test")
    public String addTest(@RequestBody Test test) {
        if (test.getQuestions() != null) {
            for (Question question : test.getQuestions()) {
                question.setTest(test);
                if (question.getOptions() != null) {
                    for (Option option : question.getOptions()) {
                        option.setQuestion(question);
                    }
                }
            }
        }
        testRepository.save(test);
        return "Test added successfully!";
    }


    @GetMapping("/all-tests")
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }


    @PostMapping("/add-question")
    public String addQuestion(@RequestBody Question question) {
        if (question.getOptions() != null) {
            for (Option option : question.getOptions()) {
                option.setQuestion(question);
            }
        }
        questionRepository.save(question);
        return "Question added successfully!";
    }


    @GetMapping("/all-questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
