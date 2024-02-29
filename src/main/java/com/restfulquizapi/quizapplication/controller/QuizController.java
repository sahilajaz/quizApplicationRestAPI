package com.restfulquizapi.quizapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restfulquizapi.quizapplication.controller.response.Response;
import com.restfulquizapi.quizapplication.entity.QuestionWrapper;
import com.restfulquizapi.quizapplication.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
    
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String difficultyLevel , @RequestParam String title) {
	  return quizService.createQuiz(difficultyLevel , title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id) {
		return quizService.getQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> response) {
		return quizService.calResult(id , response);
	}
	
	
	
}
