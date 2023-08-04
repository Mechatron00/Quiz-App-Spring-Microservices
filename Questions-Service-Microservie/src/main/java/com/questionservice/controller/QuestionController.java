package com.questionservice.controller;

import com.questionservice.model.Question;
import com.questionservice.model.QuestionWrapper;
import com.questionservice.model.Response;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{
    @Autowired
    private QuestionService service;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return service.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category)
    {
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return service.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>>getQuestionsForQuiz(@RequestParam  String category, @RequestParam Integer numberOfQuestions)
    {
        return service.getQuestionsForQuiz(category, numberOfQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer>questionIds)
    {
        System.out.println(environment.getProperty("local.server.port"));
        return service.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return service.getScore(responses);
    }
}
