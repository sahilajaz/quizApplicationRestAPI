package com.restfulquizapi.quizapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfulquizapi.quizapplication.controller.response.Response;
import com.restfulquizapi.quizapplication.dao.QuestionDao;
import com.restfulquizapi.quizapplication.dao.QuizDao;
import com.restfulquizapi.quizapplication.entity.Question;
import com.restfulquizapi.quizapplication.entity.QuestionWrapper;
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

	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer Id) {
	 	Optional<Quiz> quiz = quizDao.findById(Id);
	 	List<Question> questionFromDb = quiz.get().getQuestions();
	 	List<QuestionWrapper> questionForUser = new ArrayList<>();
	 	
	 	for(Question q : questionFromDb) {
	 		QuestionWrapper qw = new QuestionWrapper(q.getId() , q.getQuestionTitle() , q.getOption1() , q.getOption2() , q.getOption3() , q.getOption4());
	 		questionForUser.add(qw);
	 	}
		return new ResponseEntity<>(questionForUser , HttpStatus.OK);
		
	}

	public ResponseEntity<Integer> calResult(Integer id, List<Response> response) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> question = quiz.getQuestions();
		int right = 0;
		int i = 0;
		
		for(Response response1 : response) {
			if(response1.getResponse().equals(question.get(i).getRightAnswer())) {
				right++;
			}
			
			  i++;
		}
		return new ResponseEntity(right , HttpStatus.OK);
	}


}
