package com.baser.test_dashboard_final.controller;

import com.baser.test_dashboard_final.entity.Test;
import com.baser.test_dashboard_final.entity.TestResult;
import com.baser.test_dashboard_final.service.TestService;
import com.baser.test_dashboard_final.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestRepository testRepository;


    @GetMapping("/home")
    public String viewTests(Model model) {
        List<Test> tests = testRepository.findAll();
        model.addAttribute("tests", tests);
        return "home"; // home.html
    }


    @GetMapping("/submit-form")
    public String submitForm(@RequestParam Long testId, Model model) {
        Test test = testRepository.findById(testId).orElseThrow();
        model.addAttribute("test", test);
        return "submit"; // submit.html
    }


    @PostMapping("/submit-form")
    public String submitTestForm(@RequestParam Long testId, @RequestParam List<Long> selectedOptionIds, Model model) {
        TestResult result = testService.solveTest(testId, selectedOptionIds);
        model.addAttribute("result", result);
        return "result"; // result.html
    }


    @GetMapping("/all-tests")
    @ResponseBody
    public List<Test> getAllTestsForUser() {
        return testRepository.findAll();
    }


    @PostMapping("/submit")
    @ResponseBody
    public TestResult submitTest(@RequestParam Long testId, @RequestBody List<Long> selectedOptionIds) {
        return testService.solveTest(testId, selectedOptionIds);
    }
}
