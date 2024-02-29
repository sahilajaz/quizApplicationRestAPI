package com.restfulquizapi.quizapplication.controller;

import java.net.URI;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.restfulquizapi.quizapplication.entity.Question;
import com.restfulquizapi.quizapplication.service.QuestionServices;

@RestController
public class QuestionController {
	@Autowired
	QuestionServices questionServices;
	
   @GetMapping("/question/allquestions")
   public List<Question> getAllQuestions() {
	   return questionServices.AllQuestion();
   }
   
   @GetMapping("/question/{id}")
   public ResponseEntity<Object> getQuestionById(@PathVariable int id) {
	   return questionServices.questionById(id);
   }
   
   @GetMapping("/question/difficultylevel/{difficultyLevel}")
   public List<Question> getQuestionByDifficultyLevel(@PathVariable String difficultyLevel) {
	   return questionServices.questionByDifficultyLevel(difficultyLevel);
   }
   
   @PostMapping("/question/add")
   public ResponseEntity<Object> addQuestion(@RequestBody Question question) {
	   Question addquestion = questionServices.addquestion(question);
	   
	  URI link = UriComponentsBuilder.newInstance().path("{id}").buildAndExpand(addquestion.getId()).toUri();
	  return ResponseEntity.created(link).build();
   }
   
   @DeleteMapping("/question/{id}")
	public void deleteQuestionById(@PathVariable int id) {
	   questionServices.deleteById(id); 	
	}
}
