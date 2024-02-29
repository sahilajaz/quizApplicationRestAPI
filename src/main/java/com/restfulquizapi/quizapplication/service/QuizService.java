package com.restfulquizapi.quizapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfulquizapi.quizapplication.dao.QuestionDao;
import com.restfulquizapi.quizapplication.dao.QuizDao;
import com.restfulquizapi.quizapplication.entity.Question;
import com.restfulquizapi.quizapplication.entity.Quiz;

@Service
public class QuizService {
	@Autowired
   QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String difficultyLevel, String title) {
		List<Question> questions = questionDao.findByDifficultyLevelIgnoreCase(difficultyLevel); 
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
