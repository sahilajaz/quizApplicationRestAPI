package com.restfulquizapi.quizapplication.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.restfulquizapi.quizapplication.dao.QuestionDao;
import com.restfulquizapi.quizapplication.entity.Question;
import com.restfulquizapi.quizapplication.service.exception.ExceptionHandling;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionServices {
	@Autowired
	QuestionDao dao;
	ExceptionHandling exceptionHandling;
	
	public QuestionServices(ExceptionHandling exceptionHandling) {
		this.exceptionHandling = exceptionHandling;
	}
	


	public List<Question> AllQuestion() {
		return dao.findAll();
	}

	public ResponseEntity<Object> questionById(int id) {
	    Optional<Question> question = dao.findById(id);
	    if (question.isEmpty()) {
	        return exceptionHandling.questionNotFoundException();
	    }
	    
	    return new ResponseEntity<>(question, HttpStatus.OK);
	}

	public Question addquestion(Question question) {
		Question save = dao.save(question);
		return save;
	}

	public void  deleteById(int id) {
	  
		dao.deleteById(id);
	}
	public List<Question> questionByDifficultyLevel(String difficultyLevel) {
	    List<Question> questions = dao.findByDifficultyLevelIgnoreCase(difficultyLevel);
	    return questions;
	}

	
	
	
	
}
